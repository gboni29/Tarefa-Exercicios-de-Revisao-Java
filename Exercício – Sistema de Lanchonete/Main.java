import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static int proxCodigo = 1;

    public static void main(String[] args) {

        System.out.print("Nome do cliente: ");
        String cliente = sc.nextLine();

        System.out.print("Taxa de serviço (ex: 0.1 para 10%): ");
        double taxa = lerDouble();

        Pedido pedido = new Pedido(cliente, taxa);

        int op;
        do {
            System.out.println("\n1 - Adicionar Pizza");
            System.out.println("2 - Adicionar Lanche");
            System.out.println("3 - Adicionar Salgadinho");
            System.out.println("4 - Ver Nota Fiscal");
            System.out.println("5 - Receber dinheiro e calcular troco");
            System.out.println("0 - Finalizar");
            System.out.print("Escolha: ");
            op = lerInt();

            switch (op) {
                case 1: adicionarPizza(pedido); break;
                case 2: adicionarLanche(pedido); break;
                case 3: adicionarSalgadinho(pedido); break;
                case 4: pedido.mostrarFatura(); break;
                case 5: receberDinheiro(pedido); break;
            }
        } while (op != 0);

        sc.close();
    }

    private static void adicionarPizza(Pedido pedido) {
        System.out.print("Preço: ");
        double preco = lerDouble();
        LocalDate validade = lerData();
        System.out.print("Peso (g): ");
        double peso = lerDouble();

        System.out.print("Recheio: ");
        String recheio = sc.nextLine();
        System.out.print("Borda: ");
        String borda = sc.nextLine();
        System.out.print("Molho: ");
        String molho = sc.nextLine();

        pedido.adicionarItem(new Pizza(proxCodigo++, preco, validade, peso, recheio, borda, molho));
        System.out.println("Pizza adicionada.");
    }

    private static void adicionarLanche(Pedido pedido) {
        System.out.print("Preço: ");
        double preco = lerDouble();
        LocalDate validade = lerData();
        System.out.print("Peso (g): ");
        double peso = lerDouble();

        System.out.print("Tipo do pão: ");
        String pao = sc.nextLine();
        System.out.print("Recheio: ");
        String recheio = sc.nextLine();

        System.out.print("Quantos molhos? ");
        int qtd = lerInt();
        List<String> molhos = new ArrayList<>();
        for (int i = 0; i < qtd; i++) {
            System.out.print("Molho " + (i + 1) + ": ");
            molhos.add(sc.nextLine());
        }

        pedido.adicionarItem(new Lanche(proxCodigo++, preco, validade, peso, pao, recheio, molhos));
        System.out.println("Lanche adicionado.");
    }

    private static void adicionarSalgadinho(Pedido pedido) {
        System.out.print("Preço: ");
        double preco = lerDouble();
        LocalDate validade = lerData();
        System.out.print("Peso (g): ");
        double peso = lerDouble();

        System.out.print("Tipo (1=FRITO, 2=ASSADO): ");
        int t = lerInt();
        Salgadinho.TipoSalgadinho tipo = (t == 2) ? Salgadinho.TipoSalgadinho.ASSADO : Salgadinho.TipoSalgadinho.FRITO;

        System.out.print("Massa: ");
        String massa = sc.nextLine();
        System.out.print("Recheio: ");
        String recheio = sc.nextLine();

        pedido.adicionarItem(new Salgadinho(proxCodigo++, preco, validade, peso, tipo, massa, recheio));
        System.out.println("Salgadinho adicionado.");
    }

    private static void receberDinheiro(Pedido pedido) {
        pedido.calcularTotal();
        System.out.println("Total a pagar: R$ " + pedido.getTotal());

        System.out.print("Valor recebido (dinheiro): ");
        double recebido = lerDouble();

        try {
            double troco = pedido.calcularTroco(recebido);
            System.out.println("Troco: R$ " + troco);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static int lerInt() {
        while (true) {
            try {
                String s = sc.nextLine().trim();
                return Integer.parseInt(s);
            } catch (Exception e) {
                System.out.print("Número inválido. Tente novamente: ");
            }
        }
    }

    private static double lerDouble() {
        while (true) {
            try {
                String s = sc.nextLine().trim().replace(",", ".");
                return Double.parseDouble(s);
            } catch (Exception e) {
                System.out.print("Valor inválido. Tente novamente: ");
            }
        }
    }

    private static LocalDate lerData() {
        System.out.print("Validade (AAAA-MM-DD): ");
        while (true) {
            try {
                String s = sc.nextLine().trim();
                return LocalDate.parse(s);
            } catch (Exception e) {
                System.out.print("Data inválida. Use AAAA-MM-DD: ");
            }
        }
    }
}