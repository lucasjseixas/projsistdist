package sistdistrproj;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.*;

public class EchoClient2 {
    public static void main(String[] args) throws IOException {

        String serverHostname = new String("127.0.0.1");

        if (args.length > 0) serverHostname = args[0];
        System.out.println("Attemping to connect to host " + serverHostname + " on port 10008.");

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            echoSocket = new Socket(serverHostname, 10008);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + serverHostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for " + "the connection to: " + serverHostname);
            System.exit(1);
        }

        // Envio do cadastro para o servidor, INPUT do usuário -> saida em JSON //
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Digite o e-mail: ");
        String emailInput = stdIn.readLine();
        System.out.println("Digite o password: ");
        String passwordInput = stdIn.readLine();
        System.out.println("Digite o nome: ");
        String nameInput = stdIn.readLine();

        Candidate candidate = new Candidate(emailInput, passwordInput, nameInput); // Cria objeto Candidate e salva os campos ('email', 'password' e 'name') //
        CandidateRequest request = new CandidateRequest("SIGNUP_CANDIDATE", candidate); // Cria objeto CandidateRequest com o tipo de operacao e insere um objeto cadidate //

        // Cria objeto Gson e faz o parse para Json
        Gson gsonoutputCandiate = new Gson();
        String userInput = gsonoutputCandiate.toJson(request);
        out.println(userInput);
        out.flush();

//        System.out.println("Type Message (\"Bye.\" to quit)");
//        while ((userInput = stdIn.readLine()) != null) {
//            out.println(userInput);
//
//            // end loop
//            if (userInput.equals("Bye."))
//                break;
//        }

        String jsonFromServer = in.readLine();
        Gson gsontwo = new Gson();
        CandidateReturn reader = gsontwo.fromJson(jsonFromServer, CandidateReturn.class);
        System.out.println(reader.toString());

        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();
    }
}