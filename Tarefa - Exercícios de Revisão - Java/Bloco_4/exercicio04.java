package Bloco_4;

import java.util.TreeSet;

public class exercicio04 {

    public static void main(String[] args) {

        TreeSet<String> nomes = new TreeSet<>();

        nomes.add("Carlos");
        nomes.add("Ana");
        nomes.add("Pedro");
        nomes.add("Bruna");
        nomes.add("Daniel");

        System.out.println("Nomes em ordem alfabética:");

        for (String nome : nomes) {
            System.out.println(nome);
        }
    }
}
