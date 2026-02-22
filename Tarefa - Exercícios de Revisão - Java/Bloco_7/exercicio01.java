package Bloco_7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class exercicio01 {

    static class Produto {
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
        public String toString() {
            return nome + " (R$ " + preco + ")";
        }
    }

    public static void main(String[] args) {

        Map<String, List<Produto>> catalogo = new HashMap<>();

        catalogo.put("Eletrônicos", new ArrayList<>());
        catalogo.put("Livros", new ArrayList<>());
        catalogo.put("Acessórios", new ArrayList<>());

        catalogo.get("Eletrônicos").add(new Produto("Notebook", 3500.00));
        catalogo.get("Eletrônicos").add(new Produto("Monitor", 1200.00));

        catalogo.get("Livros").add(new Produto("Clean Code", 120.00));
        catalogo.get("Livros").add(new Produto("Java - Guia do Programador", 90.00));

        catalogo.get("Acessórios").add(new Produto("Mouse", 80.00));
        catalogo.get("Acessórios").add(new Produto("Headset", 250.00));

        String categoria = "Eletrônicos";

        System.out.println("Produtos da categoria: " + categoria);
        List<Produto> produtos = catalogo.get(categoria);

        if (produtos == null || produtos.isEmpty()) {
            System.out.println("Nenhum produto encontrado.");
        } else {
            for (Produto p : produtos) {
                System.out.println("- " + p);
            }
        }
    }
}
