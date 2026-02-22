package Bloco_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class exercicio02 {

    public static void main(String[] args) {

        ArrayList<Integer> numeros = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            numeros.add(random.nextInt(100));
        }

        System.out.println("Lista original: " + numeros);

        Collections.sort(numeros);

        System.out.println("Lista ordenada: " + numeros);
    }
}