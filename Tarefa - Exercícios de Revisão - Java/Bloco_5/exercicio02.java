package Bloco_5;

import java.util.HashMap;
import java.util.Map;

public class exercicio02 {

    public static void main(String[] args) {

        String texto = "Java é uma linguagem poderosa. Java é usada para backend e Java também serve para aplicativos.";

        texto = texto.toLowerCase();
        texto = texto.replaceAll("[^a-záéíóúàâêîôûãõç ]", "");

        String[] palavras = texto.split("\\s+");

        HashMap<String, Integer> contagem = new HashMap<>();

        for (String p : palavras) {
            if (!p.isEmpty()) {
                contagem.put(p, contagem.getOrDefault(p, 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : contagem.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
