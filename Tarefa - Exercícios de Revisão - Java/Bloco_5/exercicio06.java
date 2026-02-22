package Bloco_5;

import java.util.HashMap;
import java.util.Scanner;

public class exercicio06 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashMap<String, String> agenda = new HashMap<>();

        agenda.put("Gustavo", "1199999-1111");
        agenda.put("Luiz", "1198888-2222");
        agenda.put("Giovanni", "1197777-3333");

        System.out.print("Digite um nome para verificar: ");
        String nome = sc.nextLine();

        System.out.print("Digite um telefone para verificar: ");
        String telefone = sc.nextLine();

        if (agenda.containsKey(nome)) {
            System.out.println("O nome existe na agenda.");
        } else {
            System.out.println("O nome não existe na agenda.");
        }

        if (agenda.containsValue(telefone)) {
            System.out.println("O telefone existe na agenda.");
        } else {
            System.out.println("O telefone não existe na agenda.");
        }

        sc.close();
    }
}
