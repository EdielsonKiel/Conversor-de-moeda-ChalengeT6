package br.com.alura.conversordemoedas;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConversorApi {

     public void convert () throws IOException, InterruptedException {





        String api = "68e54c2ec128b93103eda570";
        String uri ="https://v6.exchangerate-api.com/v6/";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("uri" + "api" + "/pair/" ))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());



    }
}