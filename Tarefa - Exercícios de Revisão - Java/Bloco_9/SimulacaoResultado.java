package Bloco_9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimulacaoResultado {
    private double rendimentoBruto;
    private double taxaServico;
    private double rendimentoLiquido;
    private final List<String> mensagens = new ArrayList<>();

    public double getRendimentoBruto() { return rendimentoBruto; }
    public double getTaxaServico() { return taxaServico; }
    public double getRendimentoLiquido() { return rendimentoLiquido; }
    public List<String> getMensagens() { return Collections.unmodifiableList(mensagens); }

    public void setRendimentoBruto(double v) { this.rendimentoBruto = v; }
    public void setTaxaServico(double v) { this.taxaServico = v; }
    public void setRendimentoLiquido(double v) { this.rendimentoLiquido = v; }

    public void addMensagem(String msg) { mensagens.add(msg); }
}
