package Bloco_9;

public class ContaCDI extends Conta {

    private static final double TAXA_SERVICO = 0.0007;

    public ContaCDI(int numero, double saldoInicial) {
        super(numero, saldoInicial);
    }

    @Override
    public SimulacaoResultado calcularRendimento(int dias, SimulacaoContexto ctx) {
        SimulacaoResultado r = new SimulacaoResultado();

        double cdiMensal = ctx.getCdiMensal();
        double taxaDiaria = cdiMensal / 30.0;

        double rendimentoBruto = getSaldo() * taxaDiaria * dias;
        double taxaServico = rendimentoBruto * TAXA_SERVICO;
        double liquido = rendimentoBruto - taxaServico;

        r.setRendimentoBruto(rendimentoBruto);
        r.setTaxaServico(taxaServico);
        r.setRendimentoLiquido(liquido);
        r.addMensagem("Conta CDI: rendimento diário = CDI/30. Taxa serviço = 0,07% sobre ganhos.");

        return r;
    }
}
