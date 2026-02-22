package Bloco_9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContaInvestimentoAutomatico extends Conta {

    private final List<Alocacao> alocacoes = new ArrayList<>();

    public ContaInvestimentoAutomatico(int numero, double saldoInicial) {
        super(numero, saldoInicial);
    }

    public List<Alocacao> getAlocacoes() {
        return Collections.unmodifiableList(alocacoes);
    }

    public void definirAlocacoes(List<Alocacao> novas) {
        alocacoes.clear();
        if (novas != null) alocacoes.addAll(novas);
    }

    @Override
    public SimulacaoResultado calcularRendimento(int dias, SimulacaoContexto ctx) {
        SimulacaoResultado r = new SimulacaoResultado();

        if (alocacoes.isEmpty()) {
            r.addMensagem("Conta Inv. Automático sem alocações. Nenhum rendimento calculado.");
            r.setRendimentoBruto(0);
            r.setTaxaServico(0);
            r.setRendimentoLiquido(0);
            return r;
        }

        double rendimentoBrutoTotal = 0.0;
        double baseTaxaServico = 0.0;

        for (Alocacao a : alocacoes) {
            Produto p = a.getProduto();
            double valorAlocado = getSaldo() * a.getPercentual();
            double rendimentoProduto = valorAlocado * p.rendimentoPeriodo(dias);

            rendimentoBrutoTotal += rendimentoProduto;

            boolean entraNaTaxa = true;

            if (p instanceof ProdutoRendaFixa) {
                ProdutoRendaFixa rf = (ProdutoRendaFixa) p;
                if (dias < rf.getCarenciaDias()) {
                    entraNaTaxa = false;
                    r.addMensagem("Renda Fixa '" + p.getNome() + "' em carência (" + rf.getCarenciaDias()
                            + " dias). Rendimento NÃO entra no cálculo da taxa de serviço.");
                }
            }

            if (entraNaTaxa) baseTaxaServico += rendimentoProduto;
        }

        double taxa = taxaServicoPorTipoCliente(ctx.getCliente());
        double taxaServico = baseTaxaServico * taxa;
        double liquido = rendimentoBrutoTotal - taxaServico;

        r.setRendimentoBruto(rendimentoBrutoTotal);
        r.setTaxaServico(taxaServico);
        r.setRendimentoLiquido(liquido);

        return r;
    }

    private double taxaServicoPorTipoCliente(Cliente c) {
        // 0,1% PF; 0,15% PJ
        if (c instanceof PessoaJuridica) return 0.0015;
        return 0.001;
    }
}