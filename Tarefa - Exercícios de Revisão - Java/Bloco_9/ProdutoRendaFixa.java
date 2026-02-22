package Bloco_9;

public class ProdutoRendaFixa extends Produto {
    private final double rendimentoMensalFixo; 
    private final int carenciaDias;

    public ProdutoRendaFixa(int id, String nome, String descricao, double rendimentoMensalFixo, int carenciaDias) {
        super(id, nome, descricao);
        this.rendimentoMensalFixo = rendimentoMensalFixo;
        this.carenciaDias = carenciaDias;
    }

    public int getCarenciaDias() { return carenciaDias; }

    @Override
    public double rendimentoPeriodo(int dias) {

        return (rendimentoMensalFixo / 30.0) * dias;
    }
}
