package Bloco_4;

import java.util.LinkedHashSet;

public class exercicio03 {

    public static void main(String[] args) {

        LinkedHashSet<String> dias = new LinkedHashSet<>();

        dias.add("Quarta");
        dias.add("Segunda");
        dias.add("Sexta");
        dias.add("Domingo");

        System.out.println("Ordem de inserção:");

        for (String dia : dias) {
            System.out.println(dia);
        }
    }
}
