package Bloco_7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class exercicio02 {

    public static List<String> sortear3Unicos(List<String> participantes) {

        HashSet<String> unicos = new HashSet<>(participantes);
        ArrayList<String> listaUnica = new ArrayList<>(unicos);

        if (listaUnica.size() < 3) {
            throw new IllegalArgumentException("Precisa de pelo menos 3 participantes únicos.");
        }

        ArrayList<String> ganhadores = new ArrayList<>();
        Random random = new Random();

        while (ganhadores.size() < 3) {
            int idx = random.nextInt(listaUnica.size());
            String nome = listaUnica.get(idx);

            if (!ganhadores.contains(nome)) {
                ganhadores.add(nome);
            }
        }

        return ganhadores;
    }

    public static void main(String[] args) {

        ArrayList<String> participantes = new ArrayList<>();
        participantes.add("Gustavo");
        participantes.add("Luiz");
        participantes.add("Giovanni");
        participantes.add("Gustavo");
        participantes.add("Ana");
        participantes.add("Luiz");
        participantes.add("Pedro");

        System.out.println("Lista original: " + participantes);

        List<String> ganhadores = sortear3Unicos(participantes);

        System.out.println("Ganhadores: " + ganhadores);
    }
}
