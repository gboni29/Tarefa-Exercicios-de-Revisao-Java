package Bloco_1;

import java.util.Random;
import java.util.Scanner;

public class exercicio03 {
        public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int numeroSecreto = random.nextInt(100) + 1;
        int tentativa = 0;
        int palpite = 0;

        while (palpite != numeroSecreto) {

            System.out.print("Digite um número entre 1 e 100: ");
            palpite = sc.nextInt();
            tentativa++;

            if (palpite > numeroSecreto) {
                System.out.println("Muito alto!");
            } else if (palpite < numeroSecreto) {
                System.out.println("Muito baixo!");
            } else {
                System.out.println("Acertou!");
                System.out.println("Tentativas: " + tentativa);
            }
        }

        sc.close();
    }
    
}
