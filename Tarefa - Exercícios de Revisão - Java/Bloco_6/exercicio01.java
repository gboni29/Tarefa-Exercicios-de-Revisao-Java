package Bloco_6;

import java.util.LinkedList;
import java.util.Queue;

public class exercicio01 {

    public static void main(String[] args) {

        Queue<String> filaImpressao = new LinkedList<>();

        filaImpressao.add("Documento1.pdf");
        filaImpressao.add("Foto.png");
        filaImpressao.add("Trabalho.docx");
        filaImpressao.add("Planilha.xlsx");
        filaImpressao.add("Relatorio.txt");

        System.out.println("Iniciando impressão...\n");

        while (!filaImpressao.isEmpty()) {
            String documento = filaImpressao.poll(); 
            System.out.println("Imprimindo: " + documento);
        }

        System.out.println("\nFila vazia. Impressão finalizada.");
    }
}
