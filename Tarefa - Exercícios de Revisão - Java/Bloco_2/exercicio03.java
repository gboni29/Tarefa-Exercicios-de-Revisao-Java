package Bloco_2;

public class exercicio03 {

    static class Veiculo {
        protected String marca;
        protected String modelo;

        public Veiculo(String marca, String modelo) {
            this.marca = marca;
            this.modelo = modelo;
        }

        @Override
        public String toString() {
            return "Marca: " + marca + ", Modelo: " + modelo;
        }
    }

    static class Carro extends Veiculo {
        private int numeroDePortas;

        public Carro(String marca, String modelo, int numeroDePortas) {
            super(marca, modelo);
            this.numeroDePortas = numeroDePortas;
        }

        @Override
        public String toString() {
            return "Carro -> " + super.toString() + ", Portas: " + numeroDePortas;
        }
    }

    static class Moto extends Veiculo {
        private int cilindradas;

        public Moto(String marca, String modelo, int cilindradas) {
            super(marca, modelo);
            this.cilindradas = cilindradas;
        }

        @Override
        public String toString() {
            return "Moto -> " + super.toString() + ", Cilindradas: " + cilindradas;
        }
    }

    public static void main(String[] args) {
        Veiculo v1 = new Carro("Honda", "Civic", 4);
        Veiculo v2 = new Moto("Yamaha", "MT-07", 689);

        System.out.println(v1);
        System.out.println(v2);
    }
}
