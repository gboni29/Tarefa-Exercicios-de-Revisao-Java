package Bloco_9;

public abstract class Produto {
    private final int id;
    private String nome;
    private String descricao;

    protected Produto(int id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }

    public void setNome(String nome) { this.nome = nome; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public abstract double rendimentoPeriodo(int dias);

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{id=" + id + ", nome=" + nome + "}";
    }
}
