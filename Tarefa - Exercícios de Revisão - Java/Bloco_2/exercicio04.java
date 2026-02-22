package Bloco_2;

public class exercicio04 {

    static class SaldoInsuficienteException extends Exception {
        public SaldoInsuficienteException(String mensagem) {
            super(mensagem);
        }
    }

    static class ContaBancaria {
        private String titular;
        private double saldo;

        public ContaBancaria(String titular, double saldoInicial) {
            this.titular = titular;
            this.saldo = saldoInicial;
        }

        public double getSaldo() {
            return saldo;
        }

        public void depositar(double valor) {
            if (valor <= 0) {
                throw new IllegalArgumentException("Depósito deve ser maior que zero.");
            }
            saldo += valor;
        }

        public void sacar(double valor) throws SaldoInsuficienteException {
            if (valor <= 0) {
                throw new IllegalArgumentException("Saque deve ser maior que zero.");
            }

            if (valor > saldo) {
                throw new SaldoInsuficienteException(
                        "Saldo insuficiente. Saldo: " + saldo + " | Saque: " + valor
                );
            }

            saldo -= valor;
        }
    }

    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria("Gustavo", 100.0);

        try {
            System.out.println("Saldo inicial: " + conta.getSaldo());
            conta.sacar(150.0);
            System.out.println("Saque feito. Saldo: " + conta.getSaldo());
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
