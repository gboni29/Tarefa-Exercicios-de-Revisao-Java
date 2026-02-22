package Bloco_1;

public class exercicio04 {
        public static void main(String[] args) {

        int[] numeros = {4, 7, 10, 13, 18, 21, 25};
        int soma = 0;

        for (int num : numeros) {
            if (num % 2 != 0) {
                soma += num;
            }
        }

        System.out.println("Soma dos números ímpares: " + soma);
    }
}
