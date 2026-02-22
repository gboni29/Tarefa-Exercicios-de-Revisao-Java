package Bloco_9;

public class Simulador {

    public static SimulacaoResultado simularConta(Conta conta, int dias, SimulacaoContexto ctx) {
        if (dias != 30 && dias != 60 && dias != 90 && dias != 180) {
            throw new IllegalArgumentException("Período inválido. Use 30, 60, 90 ou 180 dias.");
        }
        return conta.calcularRendimento(dias, ctx);
    }
}
