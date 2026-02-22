package Bloco_9;

public class ContaCorrente extends Conta {

    public ContaCorrente(int numero, double saldoInicial) {
        super(numero, saldoInicial);
    }

    @Override
    public SimulacaoResultado calcularRendimento(int dias, SimulacaoContexto ctx) {
        SimulacaoResultado r = new SimulacaoResultado();
        r.setRendimentoBruto(0.0);
        r.setTaxaServico(0.0);
        r.setRendimentoLiquido(0.0);
        r.addMensagem("Conta Corrente não rende.");
        return r;
    }
}
