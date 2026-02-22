package Bloco_5;

import java.util.LinkedHashMap;
import java.util.Map;

public class exercicio04 {

    public static void main(String[] args) {

        LinkedHashMap<Integer, String> produtos = new LinkedHashMap<>();

        produtos.put(101, "Mouse");
        produtos.put(205, "Teclado");
        produtos.put(309, "Monitor");
        produtos.put(412, "Headset");
        produtos.put(550, "Notebook");

        for (Map.Entry<Integer, String> entry : produtos.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
