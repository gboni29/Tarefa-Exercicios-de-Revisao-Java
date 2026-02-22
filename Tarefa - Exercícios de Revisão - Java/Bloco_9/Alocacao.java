package Bloco_9;

public class Alocacao {
    private final Produto produto;
    private final double percentual; 

    public Alocacao(Produto produto, double percentual) {
        if (produto == null) throw new IllegalArgumentException("Produto inválido");
        if (percentual <= 0 || percentual > 1) throw new IllegalArgumentException("Percentual deve estar entre (0, 1]");
        this.produto = produto;
        this.percentual = percentual;
    }

    public Produto getProduto() { return produto; }
    public double getPercentual() { return percentual; }
}
