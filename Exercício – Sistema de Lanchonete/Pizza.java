import java.time.LocalDate;

public class Pizza extends Prato {
    private String recheio;
    private String borda;
    private String molho;

    public Pizza(int codigo, double precoVenda, LocalDate validade, double peso, String recheio, String borda, String molho) {
        super(codigo, precoVenda, validade, peso);
        if (isVazio(recheio) || isVazio(borda) || isVazio(molho)) {
            throw new IllegalArgumentException("Recheio, borda e molho são obrigatórios.");
        }
        this.recheio = recheio.trim();
        this.borda = borda.trim();
        this.molho = molho.trim();
    }

    public String getRecheio() { return recheio; }
    public String getBorda() { return borda; }
    public String getMolho() { return molho; }

    @Override
    public String imprimeDados() {
        return "Pizza | cod=" + getCodigo() +
                " | recheio=" + recheio + ", borda=" + borda + ", molho=" + molho +
                " | peso=" + getPeso() + "g | validade=" + getValidade() +
                " | preço=R$ " + calcularPreco();
    }

    private boolean isVazio(String s) {
        return s == null || s.trim().isEmpty();
    }
}