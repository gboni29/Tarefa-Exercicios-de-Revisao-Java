package Bloco_2;

public class exercicio02 {

    static class Circulo {
        private double raio;

        public Circulo(double raio) {
            setRaio(raio);
        }

        public double getRaio() {
            return raio;
        }

        public void setRaio(double raio) {
            if (raio <= 0) {
                throw new IllegalArgumentException("Raio deve ser maior que zero.");
            }
            this.raio = raio;
        }

        public double calcularArea() {
            return Math.PI * raio * raio;
        }
    }

    public static void main(String[] args) {
        Circulo c = new Circulo(3.0);
        System.out.println("Raio: " + c.getRaio());
        System.out.println("Área: " + c.calcularArea());

        // c.setRaio(0);
    }
}
