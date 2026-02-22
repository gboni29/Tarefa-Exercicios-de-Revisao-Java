package Bloco_5;

import java.util.HashMap;
import java.util.Scanner;

public class exercicio01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        HashMap<String, String> dicionario = new HashMap<>();
        dicionario.put("casa", "house");
        dicionario.put("carro", "car");
        dicionario.put("livro", "book");
        dicionario.put("agua", "water");
        dicionario.put("amigo", "friend");

        System.out.print("Digite uma palavra em português: ");
        String palavra = sc.nextLine().toLowerCase();

        if (dicionario.containsKey(palavra)) {
            System.out.println("Tradução: " + dicionario.get(palavra));
        } else {
            System.out.println("Palavra não encontrada no dicionário.");
        }

        sc.close();
    }
}