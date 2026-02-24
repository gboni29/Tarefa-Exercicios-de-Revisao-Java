import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pedido {
    private String nomeCliente;
    private Double taxaServico;
    private ArrayList<Prato> itensConsumidos;

    private double subtotal;
    private double total;

    public Pedido(String nomeCliente, Double taxaServico) {
        if (nomeCliente == null || nomeCliente.trim().isEmpty()) throw new IllegalArgumentException("Cliente inválido.");
        if (taxaServico == null || taxaServico < 0) throw new IllegalArgumentException("Taxa inválida.");
        this.nomeCliente = nomeCliente.trim();
        this.taxaServico = taxaServico;
        this.itensConsumidos = new ArrayList<>();
        this.subtotal = 0;
        this.total = 0;
    }

    public String getNomeCliente() { return nomeCliente; }
    public Double getTaxaServico() { return taxaServico; }
    public List<Prato> getItensConsumidos() { return Collections.unmodifiableList(itensConsumidos); }
    public double getSubtotal() { return subtotal; }
    public double getTotal() { return total; }

    public void adicionarItem(Prato prato) {
        if (prato == null) throw new IllegalArgumentException("Prato inválido.");
        itensConsumidos.add(prato);
    }

    public void calcularTotal() {
        subtotal = 0;
        for (Prato p : itensConsumidos) {
            subtotal += p.calcularPreco();
        }
        total = subtotal + (subtotal * taxaServico);
    }

    public void mostrarFatura() {
        calcularTotal();

        System.out.println("\n=== NOTA FISCAL - QUASE TRÊS LANCHES ===");
        System.out.println("Cliente: " + nomeCliente);
        System.out.println("Itens:");

        int i = 1;
        for (Prato p : itensConsumidos) {
            System.out.println(i + ") " + p.imprimeDados());
            i++;
        }

        System.out.println("\nSubtotal: R$ " + subtotal);
        System.out.println("Taxa de serviço (" + (taxaServico * 100) + "%): R$ " + (subtotal * taxaServico));
        System.out.println("Total: R$ " + total);
        System.out.println("========================================\n");
    }

    public double calcularTroco(double valorRecebido) {
        calcularTotal();
        if (valorRecebido < total) throw new IllegalArgumentException("Valor recebido insuficiente.");
        return valorRecebido - total;
    }
}