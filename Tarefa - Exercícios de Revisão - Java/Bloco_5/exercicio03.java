package Bloco_5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class exercicio03 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashMap<String, String> agenda = new HashMap<>();

        int opcao;

        do {
            System.out.println("\n1 - Adicionar contato");
            System.out.println("2 - Buscar telefone pelo nome");
            System.out.println("3 - Listar contatos");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();
                    agenda.put(nome, telefone);
                    System.out.println("Contato salvo.");
                    break;

                case 2:
                    System.out.print("Digite o nome: ");
                    String busca = sc.nextLine();

                    if (agenda.containsKey(busca)) {
                        System.out.println("Telefone: " + agenda.get(busca));
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;

                case 3:
                    if (agenda.isEmpty()) {
                        System.out.println("Agenda vazia.");
                    } else {
                        for (Map.Entry<String, String> entry : agenda.entrySet()) {
                            System.out.println(entry.getKey() + " -> " + entry.getValue());
                        }
                    }
                    break;
            }

        } while (opcao != 0);

        sc.close();
    }
}
