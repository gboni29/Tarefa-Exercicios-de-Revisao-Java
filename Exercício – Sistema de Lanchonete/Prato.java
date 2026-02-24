import java.time.LocalDate;

public abstract class Prato {
    private int codigo;
    private double precoVenda;
    private LocalDate validade;
    private double peso;

    protected Prato(int codigo, double precoVenda, LocalDate validade, double peso) {
        if (codigo <= 0) throw new IllegalArgumentException("Código inválido.");
        if (precoVenda <= 0) throw new IllegalArgumentException("Preço inválido.");
        if (validade == null) throw new IllegalArgumentException("Validade inválida.");
        if (peso <= 0) throw new IllegalArgumentException("Peso inválido.");
        this.codigo = codigo;
        this.precoVenda = precoVenda;
        this.validade = validade;
        this.peso = peso;
    }

    public int getCodigo() { return codigo; }
    public double getPrecoVenda() { return precoVenda; }
    public LocalDate getValidade() { return validade; }
    public double getPeso() { return peso; }

    public double calcularPreco() {
        return precoVenda;
    }

    public abstract String imprimeDados();
}