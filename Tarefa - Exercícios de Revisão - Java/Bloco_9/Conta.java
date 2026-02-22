package Bloco_9;

public abstract class Conta {

    private int numero;
    private double saldo;

    protected Conta(int numero, double saldoInicial) {
        if (numero <= 0) {
            throw new IllegalArgumentException("Número da conta deve ser maior que zero.");
        }
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("Saldo inicial não pode ser negativo.");
        }

        this.numero = numero;
        this.saldo = saldoInicial;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do depósito deve ser maior que zero.");
        }
        saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do saque deve ser maior que zero.");
        }
        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente para saque.");
        }
        saldo -= valor;
    }

    protected void setSaldo(double novoSaldo) {
        if (novoSaldo < 0) {
            throw new IllegalArgumentException("Saldo não pode ser negativo.");
        }
        this.saldo = novoSaldo;
    }

    public abstract SimulacaoResultado calcularRendimento(int dias, SimulacaoContexto ctx);

    @Override
    public String toString() {
        return "Conta{numero=" + numero + ", saldo=" + saldo + "}";
    }
}