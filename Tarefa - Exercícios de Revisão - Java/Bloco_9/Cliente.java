package Bloco_9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Cliente {
    private final int id;
    private String nome;
    private String email;
    private final List<Conta> contas = new ArrayList<>();

    protected Cliente(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public List<Conta> getContas() { return Collections.unmodifiableList(contas); }

    public void setNome(String nome) { this.nome = nome; }
    public void setEmail(String email) { this.email = email; }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public boolean removerContaPorNumero(int numero) {
        if (contas.size() <= 1) return false;
        return contas.removeIf(c -> c.getNumero() == numero);
    }
}
