import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lanche extends Prato {
    private String tipoPao;
    private String recheio;
    private List<String> molhos;

    public Lanche(int codigo, double precoVenda, LocalDate validade, double peso, String tipoPao, String recheio, List<String> molhos) {
        super(codigo, precoVenda, validade, peso);
        if (isVazio(tipoPao) || isVazio(recheio)) {
            throw new IllegalArgumentException("Tipo do pão e recheio são obrigatórios.");
        }
        if (molhos == null || molhos.isEmpty()) {
            throw new IllegalArgumentException("Molhos são obrigatórios.");
        }

        this.tipoPao = tipoPao.trim();
        this.recheio = recheio.trim();
        this.molhos = new ArrayList<>();
        for (String m : molhos) {
            if (!isVazio(m)) this.molhos.add(m.trim());
        }
        if (this.molhos.isEmpty()) throw new IllegalArgumentException("Molhos inválidos.");
    }

    public String getTipoPao() { return tipoPao; }
    public String getRecheio() { return recheio; }
    public List<String> getMolhos() { return Collections.unmodifiableList(molhos); }

    @Override
    public String imprimeDados() {
        return "Lanche | cod=" + getCodigo() +
                " | pão=" + tipoPao + ", recheio=" + recheio + ", molhos=" + molhos +
                " | peso=" + getPeso() + "g | validade=" + getValidade() +
                " | preço=R$ " + calcularPreco();
    }

    private boolean isVazio(String s) {
        return s == null || s.trim().isEmpty();
    }
}