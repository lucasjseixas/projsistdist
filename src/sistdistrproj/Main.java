package sistdistrproj;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) throws IOException {

        try (BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Digite o e-mail: ");
            String emailInput = inputReader.readLine();
            System.out.print("Digite o password: ");
            String passwordInput = inputReader.readLine();
            System.out.print("Digite o nome: ");
            String nameInput = inputReader.readLine();

            Candidate candidate = new Candidate(emailInput, passwordInput, nameInput);

            saveCandidateToFile(candidate, "database.json");
            List<Candidate> candidates = loadCandidatesFromFile("database.json");
            System.out.println("Candidatos no arquivo:");
            for (Candidate c : candidates) {
                System.out.println(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveCandidateToFile(Candidate candidate, String fileName) {
        Gson gson = new Gson();
        List<Candidate> candidates = loadCandidatesFromFile(fileName);
        if (candidates == null) {
            candidates = new ArrayList<>();
        }
        candidates.add(candidate);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            String json = gson.toJson(candidates);
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Candidate> loadCandidatesFromFile(String fileName) {
        List<Candidate> candidates = new ArrayList<>();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            Type listType = new TypeToken<ArrayList<Candidate>>() {
            }.getType();
            candidates = gson.fromJson(reader, listType);
        } catch (FileNotFoundException e) {
            // Se o arquivo não existe, retorna uma lista vazia
            System.err.println("Arquivo não encontrado. Criando novo arquivo.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return candidates;
    }
}