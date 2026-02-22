package Bloco_7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class exercicio05 {

    static class Aluno {
        private String nome;
        private double nota;

        public Aluno(String nome, double nota) {
            this.nome = nome;
            this.nota = nota;
        }

        public String getNome() {
            return nome;
        }

        public double getNota() {
            return nota;
        }

        @Override
        public String toString() {
            return nome + " (" + nota + ")";
        }
    }

    public static void main(String[] args) {

        List<Aluno> alunos = new ArrayList<>();
        alunos.add(new Aluno("Gustavo", 8.5));
        alunos.add(new Aluno("Luiz", 6.2));
        alunos.add(new Aluno("Ana", 4.8));
        alunos.add(new Aluno("Pedro", 7.0));
        alunos.add(new Aluno("Bruna", 5.0));

        Map<String, List<Aluno>> grupos = new HashMap<>();
        grupos.put("Aprovados", new ArrayList<>());
        grupos.put("Recuperação", new ArrayList<>());
        grupos.put("Reprovados", new ArrayList<>());

        for (Aluno a : alunos) {
            if (a.getNota() >= 7) {
                grupos.get("Aprovados").add(a);
            } else if (a.getNota() >= 5) {
                grupos.get("Recuperação").add(a);
            } else {
                grupos.get("Reprovados").add(a);
            }
        }

        System.out.println("Aprovados: " + grupos.get("Aprovados"));
        System.out.println("Recuperação: " + grupos.get("Recuperação"));
        System.out.println("Reprovados: " + grupos.get("Reprovados"));
    }
}
