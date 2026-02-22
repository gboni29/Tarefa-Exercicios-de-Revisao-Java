package Bloco_4;

import java.util.ArrayList;
import java.util.HashSet;

public class exercicio01 {

    public static void main(String[] args) {

        ArrayList<Integer> lista = new ArrayList<>();

        lista.add(10);
        lista.add(20);
        lista.add(10);
        lista.add(30);
        lista.add(20);
        lista.add(40);

        System.out.println("Lista original: " + lista);

        HashSet<Integer> semDuplicados = new HashSet<>(lista);

        System.out.println("Lista sem duplicados: " + semDuplicados);
    }
}