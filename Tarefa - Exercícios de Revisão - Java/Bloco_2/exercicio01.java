package Bloco_2;

public class exercicio01 {

    static class Carro {
        private String marca;
        private String modelo;
        private int ano;

        public Carro(String marca, String modelo, int ano) {
            this.marca = marca;
            this.modelo = modelo;
            this.ano = ano;
        }

        public String getMarca() {
            return marca;
        }

        public String getModelo() {
            return modelo;
        }

        public int getAno() {
            return ano;
        }

        public void exibirInfo() {
            System.out.println("Marca: " + marca);
            System.out.println("Modelo: " + modelo);
            System.out.println("Ano: " + ano);
        }
    }

    public static void main(String[] args) {
        Carro c1 = new Carro("Toyota", "Corolla", 2020);
        c1.exibirInfo();
    }
}
