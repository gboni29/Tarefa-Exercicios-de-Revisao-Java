package Bloco_6;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class exercicio02 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Deque<String> pilhaLivros = new ArrayDeque<>();

        for (int i = 1; i <= 3; i++) {
            System.out.print("Digite o nome do livro " + i + ": ");
            String livro = sc.nextLine();
            pilhaLivros.push(livro); 
        }

        String removido = pilhaLivros.pop(); 
        System.out.println("\nLivro removido (pop): " + removido);

        String topo = pilhaLivros.peek(); 
        System.out.println("Livro no topo (peek): " + topo);

        sc.close();
    }
}