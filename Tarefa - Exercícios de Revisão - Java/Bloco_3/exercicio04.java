package Bloco_3;

import java.util.ArrayList;
import java.util.Scanner;

public class exercicio04 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> cidades = new ArrayList<>();
        cidades.add("São Paulo");
        cidades.add("Rio de Janeiro");
        cidades.add("Belo Horizonte");
        cidades.add("Curitiba");
        cidades.add("Salvador");

        System.out.print("Digite o nome da cidade: ");
        String busca = sc.nextLine();

        if (cidades.contains(busca)) {
            int indice = cidades.indexOf(busca);
            System.out.println("Cidade encontrada no índice: " + indice);
        } else {
            System.out.println("Cidade não encontrada.");
        }

        sc.close();
    }
}
