package com.LiterAlura.LiterAlura.principal;

import java.util.Scanner;

public class ExibeMenu {

   public String ExibirMenu(){
      final String endereco="https://www.omdbapi.com/?t=";
      final String API_KEY = "&apikey=6585022c";

       Scanner leitura = new Scanner(System.in);
       System.out.println("Digite uma série para busca:");

       var nomeSerie = leitura.nextLine();
       nomeSerie= nomeSerie.replace(" ","+");

       String enderecoApi = endereco+nomeSerie+API_KEY;

     return enderecoApi;

   }
}
