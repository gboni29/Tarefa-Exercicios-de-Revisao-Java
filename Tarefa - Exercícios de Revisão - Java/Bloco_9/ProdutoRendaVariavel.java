package Bloco_9;

public class ProdutoRendaVariavel extends Produto {
    private final double rendimentoMensalEsperado; 

    public ProdutoRendaVariavel(int id, String nome, String descricao, double rendimentoMensalEsperado) {
        super(id, nome, descricao);
        this.rendimentoMensalEsperado = rendimentoMensalEsperado;
    }

    @Override
    public double rendimentoPeriodo(int dias) {
        return (rendimentoMensalEsperado / 30.0) * dias;
    }
}
