package Bloco_7;

import java.util.LinkedList;

public class exercicio04 {

    static class HistoricoNavegacao {
        private LinkedList<String> historico = new LinkedList<>();
        private int atual = -1;

        public void visitar(String url) {

            while (historico.size() > atual + 1) {
                historico.removeLast();
            }

            historico.add(url);
            atual++;

            System.out.println("Visitando: " + url);
        }

        public void voltar() {
            if (atual > 0) {
                atual--;
                System.out.println("Voltou para: " + historico.get(atual));
            } else {
                System.out.println("Não dá pra voltar.");
            }
        }

        public void avancar() {
            if (atual < historico.size() - 1) {
                atual++;
                System.out.println("Avançou para: " + historico.get(atual));
            } else {
                System.out.println("Não dá pra avançar.");
            }
        }

        public void exibirEstado() {
            System.out.println("Histórico: " + historico);
            if (atual >= 0) {
                System.out.println("Página atual: " + historico.get(atual));
            } else {
                System.out.println("Sem página atual.");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        HistoricoNavegacao nav = new HistoricoNavegacao();

        nav.visitar("google.com");
        nav.visitar("github.com");
        nav.visitar("ifsp.edu.br");
        nav.exibirEstado();

        nav.voltar();
        nav.voltar();
        nav.exibirEstado();

        nav.avancar();
        nav.exibirEstado();

        nav.visitar("youtube.com");
        nav.exibirEstado();

        nav.avancar();
    }
}
