package Bloco_4;

import java.util.TreeSet;

public class exercicio05 {

    static class Produto implements Comparable<Produto> {

        private String nome;
        private double preco;

        public Produto(String nome, double preco) {
            this.nome = nome;
            this.preco = preco;
        }

        public String getNome() {
            return nome;
        }

        public double getPreco() {
            return preco;
        }

        @Override
        public int compareTo(Produto outro) {
            return Double.compare(this.preco, outro.preco);
        }

        @Override
        public String toString() {
            return nome + " - R$ " + preco;
        }
    }

    public static void main(String[] args) {

        TreeSet<Produto> produtos = new TreeSet<>();

        produtos.add(new Produto("Notebook", 3500.00));
        produtos.add(new Produto("Mouse", 80.00));
        produtos.add(new Produto("Teclado", 150.00));
        produtos.add(new Produto("Monitor", 1200.00));
        produtos.add(new Produto("Headset", 250.00));

        System.out.println("Produtos ordenados pelo preço:");

        for (Produto p : produtos) {
            System.out.println(p);
        }
    }
}