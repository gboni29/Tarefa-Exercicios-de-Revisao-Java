package Bloco_9;

public class PessoaFisica extends Cliente {
    private final String cpf;

    public PessoaFisica(int id, String nome, String cpf, String email) {
        super(id, nome, email);
        this.cpf = cpf;
    }

    public String getCpf() { return cpf; }

    @Override
    public String toString() {
        return "PF{id=" + getId() + ", nome=" + getNome() + ", cpf=" + cpf + ", email=" + getEmail() + "}";
    }
}