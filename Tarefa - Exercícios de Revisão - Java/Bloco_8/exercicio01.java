package Bloco_8;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class exercicio01 {

    static class AnalisadorDeClasse {

        public static void inspecionar(Object obj) {
            if (obj == null) {
                System.out.println("Objeto nulo.");
                return;
            }

            Class<?> clazz = obj.getClass();

            System.out.println("Classe: " + clazz.getName());

            System.out.println("\nAtributos (campos):");
            Field[] campos = clazz.getDeclaredFields();
            for (Field f : campos) {
                System.out.println("- " + f.getName());
            }

            System.out.println("\nMétodos:");
            Method[] metodos = clazz.getDeclaredMethods();
            for (Method m : metodos) {
                System.out.println("- " + m.getName());
            }
        }
    }

    static class Produto {
        private int codigo;
        public String nome;
        protected double preco;

        public Produto(int codigo, String nome, double preco) {
            this.codigo = codigo;
            this.nome = nome;
            this.preco = preco;
        }

        private double calcularImposto() {
            return preco * 0.1;
        }
    }

    public static void main(String[] args) {
        Produto p = new Produto(101, "Notebook Gamer", 8500.0);
        AnalisadorDeClasse.inspecionar(p);
    }
}
