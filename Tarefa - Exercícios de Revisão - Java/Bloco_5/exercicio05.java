package Bloco_5;

import java.util.Map;
import java.util.TreeMap;

public class exercicio05 {

    public static void main(String[] args) {

        TreeMap<String, Double> notas = new TreeMap<>();

        notas.put("Carlos", 7.5);
        notas.put("Ana", 9.0);
        notas.put("Pedro", 6.0);
        notas.put("Bruna", 8.2);
        notas.put("Daniel", 5.7);

        for (Map.Entry<String, Double> entry : notas.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}