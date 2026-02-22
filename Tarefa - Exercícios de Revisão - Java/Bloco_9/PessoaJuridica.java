package Bloco_9;

public class PessoaJuridica extends Cliente {
    private final String cnpj;

    public PessoaJuridica(int id, String nome, String cnpj, String email) {
        super(id, nome, email);
        this.cnpj = cnpj;
    }

    public String getCnpj() { return cnpj; }

    @Override
    public String toString() {
        return "PJ{id=" + getId() + ", nome=" + getNome() + ", cnpj=" + cnpj + ", email=" + getEmail() + "}";
    }
}
