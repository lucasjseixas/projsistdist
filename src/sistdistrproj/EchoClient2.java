package sistdistrproj;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.*;
import java.util.Objects;
import java.util.Scanner;

public class EchoClient2 {
    public static void main(String[] args) throws IOException {


        String serverHostname = new String("127.0.0.1");

        if (args.length > 0) serverHostname = args[0];
        System.out.println("Attemping to connect to host " + serverHostname + " on port 10008.");


        try {
            // Envio do cadastro para o servidor, INPUT do usuário -> saida em JSON //
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Menu:");
                System.out.println("1. Cadastrar");
                System.out.println("2. Logar");
                System.out.println("3. Editar");
                System.out.println("4. Apagar");
                System.out.println("9. Sair");
                System.out.print("Selecione uma opção: ");

                if (scanner.hasNextInt()) {
                    int escolha = scanner.nextInt();
                    scanner.nextLine();
                    scanner.reset();
                    switch (escolha) {
                        case 1:
                            cadastrar(serverHostname);
                            break;
                        case 2:
                            logar(serverHostname);
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 9:
                            System.out.println("Terminando o programa...");
                            stdIn.close();
                            scanner.close();
                            return;

                        default:
                            System.out.println("Opcao Invalida. Seleciona uma opcao de '1' a '5' ou Digite '9' para sair");
                    }
                } else {  // Consume invalid input
                    scanner.nextLine();
                    System.out.println("Opcao Invalida. Seleciona uma opcao de '1' a '5' ou Digite '9' para sair");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void cadastrar(String serverHostname) {

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            echoSocket = new Socket(serverHostname, 10008);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));

            // Envio do cadastro para o servidor, INPUT do usuário -> saida em JSON //
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Cadastrando...");
            System.out.println("Digite o e-mail: ");
            String emailInput = stdIn.readLine();
            System.out.println("Digite o password: ");
            String passwordInput = stdIn.readLine();
            System.out.println("Digite o nome: ");
            String nameInput = stdIn.readLine();

            Data data = new Data(emailInput, passwordInput, nameInput); // Cria objeto Candidate e salva os campos ('email', 'password' e 'name') //
            CandidateRequest request = new CandidateRequest("SIGNUP_CANDIDATE", data); // Cria objeto CandidateRequest com o tipo de operacao e insere um objeto cadidate //

            // Cria objeto Gson e faz o parse para Json
            Gson gsonoutputCandiate = new Gson();
            String userInput = gsonoutputCandiate.toJson(request);
            out.println(userInput); // Saida para o Server
            out.flush();

            // Resposta do Server
            String jsonFromServer = in.readLine();
            Gson gsontwo = new Gson();
            CandidateReturn reader = gsontwo.fromJson(jsonFromServer, CandidateReturn.class);
//            if (Objects.equals(reader.getStatus(), "INVALID_FIELD")) {
//                System.out.println("INVALID_FIELD");
//            }
            try (FileWriter fileWriter = new FileWriter("databaseclient.json")) {
                gsontwo.toJson(reader, fileWriter);
                System.out.println("JSON escrito em databaseclient.json");
            } catch (IOException e) {
                e.printStackTrace();
            }
            // Fecha I/O
            out.close();
            in.close();
            echoSocket.close();
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + serverHostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for " + "the connection to: " + serverHostname);
            System.exit(1);
        }
    }

    public static void logar(String serverHostname) {

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            echoSocket = new Socket(serverHostname, 10008);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));

            // Envio do cadastro para o servidor, INPUT do usuário -> saida em JSON //
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Logando...");
            System.out.println("Digite o e-mail: ");
            String emailInput = stdIn.readLine();
            System.out.println("Digite o password: ");
            String passwordInput = stdIn.readLine();
            DataLogar dataLogar = new DataLogar(emailInput, passwordInput); // Cria objeto Candidate e salva os campos ('email', 'password' e 'name') //
            CandidateRequestLogar request = new CandidateRequestLogar("LOGIN_CANDIDATE", dataLogar); // Cria objeto CandidateRequest com o tipo de operacao e insere um objeto cadidate //

            // Cria objeto Gson e faz o parse para Json
            Gson gsonoutputCandiate = new Gson();
            String userInput = gsonoutputCandiate.toJson(request);
            out.println(userInput); // Saida para o Server
            out.flush();

            // Resposta do Server
            String jsonFromServer = in.readLine();
            Gson gsontwo = new Gson();
            CandidateReturn reader = gsontwo.fromJson(jsonFromServer, CandidateReturn.class);
//            if (Objects.equals(reader.getStatus(), "USER_NOT_FOUND")) {
//                System.out.println("USER_NOT_FOUND");
//            }else if(Objects.equals(reader.getStatus(), "INVALID_PASSWORD")){
            //                System.out.println("INVALID_PASSWORD");
            //}
            try (FileWriter fileWriter = new FileWriter("databaseclient.json")) {
                gsontwo.toJson(reader, fileWriter);
                System.out.println("JSON escrito em databaseclient.json");
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + serverHostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for " + "the connection to: " + serverHostname);
            System.exit(1);
        }
    }
}


//        System.out.println("Type Message (\"Bye.\" to quit)");
//        while ((userInput = stdIn.readLine()) != null) {
//            out.println(userInput);
//
//            // end loop
//            if (userInput.equals("Bye."))
//                break;
//        }
