import java.time.LocalDate;

public class Salgadinho extends Prato {

    public enum TipoSalgadinho {
        FRITO, ASSADO
    }

    private TipoSalgadinho tipo;
    private String massa;
    private String recheio;

    public Salgadinho(int codigo, double precoVenda, LocalDate validade, double peso, TipoSalgadinho tipo, String massa, String recheio) {
        super(codigo, precoVenda, validade, peso);
        if (tipo == null) throw new IllegalArgumentException("Tipo do salgadinho é obrigatório.");
        if (isVazio(massa) || isVazio(recheio)) throw new IllegalArgumentException("Massa e recheio são obrigatórios.");
        this.tipo = tipo;
        this.massa = massa.trim();
        this.recheio = recheio.trim();
    }

    public TipoSalgadinho getTipo() { return tipo; }
    public String getMassa() { return massa; }
    public String getRecheio() { return recheio; }

    @Override
    public String imprimeDados() {
        return "Salgadinho | cod=" + getCodigo() +
                " | tipo=" + tipo + ", massa=" + massa + ", recheio=" + recheio +
                " | peso=" + getPeso() + "g | validade=" + getValidade() +
                " | preço=R$ " + calcularPreco();
    }

    private boolean isVazio(String s) {
        return s == null || s.trim().isEmpty();
    }
}