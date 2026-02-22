package Bloco_9;

public class SimulacaoContexto {
    private final Cliente cliente;
    private final double cdiMensal;

    public SimulacaoContexto(Cliente cliente, double cdiMensal) {
        this.cliente = cliente;
        this.cdiMensal = cdiMensal;
    }

    public Cliente getCliente() { return cliente; }
    public double getCdiMensal() { return cdiMensal; }
}
