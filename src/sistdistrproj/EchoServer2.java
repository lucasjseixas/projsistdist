package sistdistrproj;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EchoServer2 extends Thread {
    protected Socket clientSocket;

    private EchoServer2(Socket clientSoc) {
        clientSocket = clientSoc;
        start();
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(10008);
            System.out.println("Connection Socket Created");
            try {
                while (true) {
                    System.out.println("Waiting for Connection");
                    new EchoServer2(serverSocket.accept());
                }
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port: 10008.");
            System.exit(1);
        } finally {
            try {
                assert serverSocket != null;
                serverSocket.close();
            } catch (IOException e) {
                System.err.println("Could not close port: 10008.");
                System.exit(1);
            }
        }
    }

    // Json para File ('fileName'.json) //
    private static void saveCandidateToFile(CandidateRequest request, String fileName) {
        Gson gson = new Gson();
        List<CandidateRequest> requests = loadCandidatesFromFile(fileName);
        if (requests == null) {
            requests = new ArrayList<>();
        }
        requests.add(request);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            String json = gson.toJson(requests);
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // File ('fileName'.json) para Objeto //
    private static List<CandidateRequest> loadCandidatesFromFile(String fileName) {
        List<CandidateRequest> requests = new ArrayList<>();
        Gson gson = new Gson();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            requests = gson.fromJson(reader, new com.google.gson.reflect.TypeToken<List<CandidateRequest>>() {
            }.getType());
        } catch (FileNotFoundException e) {
            // Se o arquivo não existir, retorna uma lista vazia //
            System.err.println("Arquivo JSON não encontrado, criando arquivo...");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return requests;
    }

    public void run() {
        System.out.println("New Communication Thread Started");

        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),
                    true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));


            String inputLine = in.readLine();
            // Recebeu em String do in, vindo do client
            //System.out.println("Received: " + inputLine); // Apenas mostrando o que recebeu

            Gson gson = new Gson();
            CandidateRequest requestReceivedObj = gson.fromJson(inputLine, CandidateRequest.class);

            // Filtrando somente o campo 'data' vindo do client
            CandidateRequest filteredRequest = new CandidateRequest();
            filteredRequest.setData(requestReceivedObj.getData());

            /******/ /* Aqui será adicionada a checagem do campo 'data' e a inclusao do tratamento de erro */ /******/

            // Retorna para o client um JSON do tipo CandidateReturn //
            CandidateReturn retornoClient = new CandidateReturn("SIGNUP_CANDIDATE", "SUCCESS");

            String teste = gson.toJson(retornoClient);
            out.println(teste);
            out.flush();

//                // Cadastra em JSON o Candidate
//                try (FileWriter fileWriter = new FileWriter("output.json")) {
//                    gson.toJson(filteredRequest, fileWriter);
//                    System.out.println("JSON escrito em output.json");
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }


//            while ((inputLine = in.readLine()) != null) {
//                System.out.println("Server: " + inputLine);
//                out.println(inputLine);
//
//                if (inputLine.equals("Bye."))
//                    break;
//            }

            // Fecha I/O e socket de conexao com o cliente
            out.close();
            in.close();
            clientSocket.close();
        } catch (IOException e) {
            System.err.println("Problem with Communication Server");
            System.exit(1);
        }
    }
}
