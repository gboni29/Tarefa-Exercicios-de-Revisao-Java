package Bloco_7;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class exercicio03 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Deque<String> pilha = new ArrayDeque<>();

        System.out.print("Digite uma frase: ");
        String frase = sc.nextLine().trim();

        if (!frase.isEmpty()) {
            String[] palavras = frase.split("\\s+");
            for (String p : palavras) {
                pilha.push(p);
            }
        }

        StringBuilder invertida = new StringBuilder();

        while (!pilha.isEmpty()) {
            invertida.append(pilha.pop());
            if (!pilha.isEmpty()) invertida.append(" ");
        }

        System.out.println("Frase invertida: " + invertida);

        sc.close();
    }
}
