//package sistdistrproj;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.google.gson.*;
//
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//
//        try (BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in))) {
//            System.out.println("Digite o e-mail: ");
//            String emailInput = inputReader.readLine();
//            System.out.println("Digite o password: ");
//            String passwordInput = inputReader.readLine();
//            System.out.println("Digite o nome: ");
//            String nameInput = inputReader.readLine();
//
//            Candidate candidate = new Candidate(emailInput, passwordInput, nameInput);
//            CandidateRequest request = new CandidateRequest("SIGNUP_CANDIDATE", candidate); // REQUEST deve ser passado pelo 'SOCKET DO CLIENTE' PARA O 'SERVIDOR'
//
//            Gson gsonoutputCandiate = new Gson();
//            String jsonOutPutCandidate = gsonoutputCandiate.toJson(request); // Saída em JSON para o servidor
//
//
//            // Salvado candidatos em um 'fileName'.json //
//            saveCandidateToFile(request, "database.json");
//
//            // Para saber a lista de candidatos registrados (Trocar por um hashmap para ter ID dos candidatos) //
//            List<CandidateRequest> requests = loadCandidatesFromFile("database.json");
//            System.out.println("Candidatos no arquivo:");
//            for (CandidateRequest req : requests) {
//                System.out.println(req);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /* Criacao de log em JSON das operacoes */
//
//    // Json para File ('fileName'.json) //
//    private static void saveCandidateToFile(CandidateRequest request, String fileName) {
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        List<CandidateRequest> requests = loadCandidatesFromFile(fileName);
//        if (requests == null) {
//            requests = new ArrayList<>();
//        }
//        requests.add(request);
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
//            String json = gson.toJson(requests);
//            writer.write(json);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // File ('fileName'.json) para Objeto //
//    private static List<CandidateRequest> loadCandidatesFromFile(String fileName) {
//        List<CandidateRequest> requests = new ArrayList<>();
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
//            requests = gson.fromJson(reader, new com.google.gson.reflect.TypeToken<List<CandidateRequest>>() {
//            }.getType());
//        } catch (FileNotFoundException e) {
//            // Se o arquivo não existir, retorna uma lista vazia //
//            System.err.println("Arquivo JSON não encontrado, criando arquivo...");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return requests;
//    }
//}