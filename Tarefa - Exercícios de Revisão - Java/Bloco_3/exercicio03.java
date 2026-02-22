package Bloco_3;

import java.util.LinkedList;

public class exercicio03 {

    public static void main(String[] args) {

        LinkedList<String> fila = new LinkedList<>();

        fila.addLast("João");
        fila.addLast("Maria");
        fila.addLast("Carlos");
        fila.addLast("Ana");
        fila.addLast("Pedro");

        System.out.println("Fila inicial: " + fila);

        fila.removeFirst();
        fila.removeFirst();

        fila.addFirst("Cliente VIP 1");
        fila.addFirst("Cliente VIP 2");

        System.out.println("Fila final: " + fila);
    }
}
