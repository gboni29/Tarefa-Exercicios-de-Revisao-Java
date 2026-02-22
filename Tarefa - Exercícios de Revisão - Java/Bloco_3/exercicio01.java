package Bloco_3;

import java.util.ArrayList;
import java.util.Scanner;

public class exercicio01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> tarefas = new ArrayList<>();

        int opcao;

        do {
            System.out.println("\n1 - Adicionar tarefa");
            System.out.println("2 - Remover tarefa pelo índice");
            System.out.println("3 - Listar tarefas");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    System.out.print("Digite a tarefa: ");
                    String tarefa = sc.nextLine();
                    tarefas.add(tarefa);
                    break;

                case 2:
                    System.out.print("Digite o índice para remover: ");
                    int indice = sc.nextInt();

                    if (indice >= 0 && indice < tarefas.size()) {
                        tarefas.remove(indice);
                        System.out.println("Tarefa removida.");
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;

                case 3:
                    for (int i = 0; i < tarefas.size(); i++) {
                        System.out.println(i + " - " + tarefas.get(i));
                    }
                    break;

            }

        } while (opcao != 0);

        sc.close();
    }
}