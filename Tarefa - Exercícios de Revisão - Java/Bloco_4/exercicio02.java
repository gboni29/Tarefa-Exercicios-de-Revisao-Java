package Bloco_4;

import java.util.HashSet;

public class exercicio02 {

    public static void main(String[] args) {

        HashSet<String> emails = new HashSet<>();

        emails.add("gustavo@email.com");
        emails.add("luiz@email.com");
        emails.add("giovani@email.com");
        emails.add("gustavo@email.com"); 

        System.out.println("E-mails cadastrados: " + emails);
        System.out.println("Quantidade de e-mails únicos: " + emails.size());
    }
}