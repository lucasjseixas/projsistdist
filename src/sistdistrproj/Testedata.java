package sistdistrproj;

import com.google.gson.Gson;

public class Testedata {

    String algo;
    DataTest teste;

    public Testedata() {
        this.algo = "teste";
        this.teste = new DataTest();

    }

    public static void main(String[] args) {

        Testedata test = new Testedata();
        Gson gson = new Gson();
        String json = gson.toJson(test);
        System.out.println(json);

    }
}