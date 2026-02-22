package Bloco_9;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final Repositorios repo = new Repositorios();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        seed();

        int op;
        do {
            System.out.println("\n=== VcRiquinho (Protótipo CLI) ===");
            System.out.println("1 - CRUD Clientes");
            System.out.println("2 - CRUD Produtos");
            System.out.println("3 - Simular rendimento / taxa serviço");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            op = lerInt();

            switch (op) {
                case 1: menuClientes(); break;
                case 2: menuProdutos(); break;
                case 3: menuSimulacao(); break;
            }
        } while (op != 0);

        sc.close();
    }

    private static void menuClientes() {
        int op;
        do {
            System.out.println("\n--- CRUD Clientes ---");
            System.out.println("1 - Criar PF");
            System.out.println("2 - Criar PJ");
            System.out.println("3 - Listar");
            System.out.println("4 - Atualizar (nome/email)");
            System.out.println("5 - Remover cliente");
            System.out.println("6 - Gerenciar contas do cliente");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            op = lerInt();

            switch (op) {
                case 1: criarPF(); break;
                case 2: criarPJ(); break;
                case 3: listarClientes(); break;
                case 4: atualizarCliente(); break;
                case 5: removerCliente(); break;
                case 6: menuContas(); break;
            }
        } while (op != 0);
    }

    private static void menuProdutos() {
        int op;
        do {
            System.out.println("\n--- CRUD Produtos ---");
            System.out.println("1 - Criar Renda Fixa");
            System.out.println("2 - Criar Renda Variável");
            System.out.println("3 - Listar");
            System.out.println("4 - Atualizar (nome/descrição)");
            System.out.println("5 - Remover produto");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            op = lerInt();

            switch (op) {
                case 1: criarRendaFixa(); break;
                case 2: criarRendaVariavel(); break;
                case 3: listarProdutos(); break;
                case 4: atualizarProduto(); break;
                case 5: removerProduto(); break;
            }
        } while (op != 0);
    }

    private static void menuSimulacao() {
        System.out.println("\n--- Simulação ---");
        listarClientes();
        System.out.print("ID do cliente: ");
        int id = lerInt();

        Cliente c = repo.clientes.get(id);
        if (c == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        System.out.print("Período (30/60/90/180): ");
        int dias = lerInt();

        System.out.print("CDI mensal (ex: 0.01 = 1% ao mês): ");
        double cdiMensal = lerDouble();

        SimulacaoContexto ctx = new SimulacaoContexto(c, cdiMensal);

        System.out.println("\nContas do cliente:");
        for (Conta conta : c.getContas()) {
            System.out.println(" - " + conta);
        }

        System.out.print("Número da conta para simular: ");
        int numero = lerInt();

        Conta contaEscolhida = null;
        for (Conta conta : c.getContas()) {
            if (conta.getNumero() == numero) {
                contaEscolhida = conta;
                break;
            }
        }

        if (contaEscolhida == null) {
            System.out.println("Conta não encontrada.");
            return;
        }

        try {
            SimulacaoResultado r = Simulador.simularConta(contaEscolhida, dias, ctx);

            System.out.println("\n=== Resultado ===");
            System.out.println("Rendimento bruto: " + r.getRendimentoBruto());
            System.out.println("Taxa de serviço: " + r.getTaxaServico());
            System.out.println("Rendimento líquido: " + r.getRendimentoLiquido());

            if (!r.getMensagens().isEmpty()) {
                System.out.println("\nObservações:");
                for (String msg : r.getMensagens()) System.out.println("- " + msg);
            }
        } catch (Exception e) {
            System.out.println("Erro na simulação: " + e.getMessage());
        }
    }

    private static void menuContas() {
        listarClientes();
        System.out.print("ID do cliente: ");
        int id = lerInt();

        Cliente c = repo.clientes.get(id);
        if (c == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        int op;
        do {
            System.out.println("\n--- Contas do Cliente ---");
            System.out.println("Cliente: " + c);
            System.out.println("1 - Listar contas");
            System.out.println("2 - Adicionar Conta Corrente");
            System.out.println("3 - Adicionar Conta CDI");
            System.out.println("4 - Adicionar Conta Invest. Automático (com alocações)");
            System.out.println("5 - Remover conta (obrigatório manter >= 1)");
            System.out.println("6 - Depositar em uma conta");
            System.out.println("7 - Sacar de uma conta");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            op = lerInt();

            switch (op) {
                case 1:
                    for (Conta conta : c.getContas()) System.out.println(" - " + conta);
                    break;
                case 2: {
                    System.out.print("Saldo inicial: ");
                    double saldo = lerDouble();
                    c.adicionarConta(new ContaCorrente(repo.seqConta.getAndIncrement(), saldo));
                    System.out.println("Conta Corrente criada.");
                    break;
                }
                case 3: {
                    System.out.print("Saldo inicial: ");
                    double saldo = lerDouble();
                    c.adicionarConta(new ContaCDI(repo.seqConta.getAndIncrement(), saldo));
                    System.out.println("Conta CDI criada.");
                    break;
                }
                case 4:
                    criarContaInvestAuto(c);
                    break;
                case 5: {
                    System.out.print("Número da conta para remover: ");
                    int num = lerInt();
                    boolean ok = c.removerContaPorNumero(num);
                    if (ok) System.out.println("Conta removida.");
                    else System.out.println("Não foi possível remover (ou é a última conta).");
                    break;
                }
                case 6:
                    operarDeposito(c);
                    break;
                case 7:
                    operarSaque(c);
                    break;
            }
        } while (op != 0);
    }

    private static void operarDeposito(Cliente c) {
        if (c.getContas().isEmpty()) {
            System.out.println("Cliente sem contas.");
            return;
        }

        System.out.println("\nContas do cliente:");
        for (Conta conta : c.getContas()) System.out.println(" - " + conta);

        System.out.print("Número da conta: ");
        int numero = lerInt();

        Conta contaEscolhida = null;
        for (Conta conta : c.getContas()) {
            if (conta.getNumero() == numero) {
                contaEscolhida = conta;
                break;
            }
        }

        if (contaEscolhida == null) {
            System.out.println("Conta não encontrada.");
            return;
        }

        System.out.print("Valor do depósito: ");
        double valor = lerDouble();

        try {
            contaEscolhida.depositar(valor);
            System.out.println("Depósito realizado. Novo saldo: " + contaEscolhida.getSaldo());
        } catch (Exception e) {
            System.out.println("Erro no depósito: " + e.getMessage());
        }
    }

    private static void operarSaque(Cliente c) {
        if (c.getContas().isEmpty()) {
            System.out.println("Cliente sem contas.");
            return;
        }

        System.out.println("\nContas do cliente:");
        for (Conta conta : c.getContas()) System.out.println(" - " + conta);

        System.out.print("Número da conta: ");
        int numero = lerInt();

        Conta contaEscolhida = null;
        for (Conta conta : c.getContas()) {
            if (conta.getNumero() == numero) {
                contaEscolhida = conta;
                break;
            }
        }

        if (contaEscolhida == null) {
            System.out.println("Conta não encontrada.");
            return;
        }

        System.out.print("Valor do saque: ");
        double valor = lerDouble();

        try {
            contaEscolhida.sacar(valor);
            System.out.println("Saque realizado. Novo saldo: " + contaEscolhida.getSaldo());
        } catch (Exception e) {
            System.out.println("Erro no saque: " + e.getMessage());
        }
    }

    private static void criarPF() {
        int id = repo.seqCliente.getAndIncrement();

        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Saldo inicial da primeira conta (Conta Corrente): ");
        double saldoInicial = lerDouble();

        PessoaFisica pf = new PessoaFisica(id, nome, cpf, email);
        pf.adicionarConta(new ContaCorrente(repo.seqConta.getAndIncrement(), saldoInicial));

        repo.clientes.put(id, pf);
        System.out.println("Cliente PF criado com ID " + id + ".");
    }

    private static void criarPJ() {
        int id = repo.seqCliente.getAndIncrement();

        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("CNPJ: ");
        String cnpj = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Saldo inicial da primeira conta (Conta Corrente): ");
        double saldoInicial = lerDouble();

        PessoaJuridica pj = new PessoaJuridica(id, nome, cnpj, email);
        pj.adicionarConta(new ContaCorrente(repo.seqConta.getAndIncrement(), saldoInicial));

        repo.clientes.put(id, pj);
        System.out.println("Cliente PJ criado com ID " + id + ".");
    }

    private static void listarClientes() {
        System.out.println("\nClientes:");
        if (repo.clientes.isEmpty()) {
            System.out.println("(vazio)");
            return;
        }
        for (Map.Entry<Integer, Cliente> e : repo.clientes.entrySet()) {
            System.out.println(e.getValue() + " | contas=" + e.getValue().getContas().size());
        }
    }

    private static void atualizarCliente() {
        listarClientes();
        System.out.print("ID do cliente: ");
        int id = lerInt();
        Cliente c = repo.clientes.get(id);
        if (c == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }
        System.out.print("Novo nome: ");
        String nome = sc.nextLine();
        System.out.print("Novo email: ");
        String email = sc.nextLine();
        c.setNome(nome);
        c.setEmail(email);
        System.out.println("Atualizado.");
    }

    private static void removerCliente() {
        listarClientes();
        System.out.print("ID do cliente para remover: ");
        int id = lerInt();
        Cliente removido = repo.clientes.remove(id);
        if (removido == null) System.out.println("Cliente não encontrado.");
        else System.out.println("Removido: " + removido);
    }

    private static void criarRendaFixa() {
        int id = repo.seqProduto.getAndIncrement();

        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Descrição: ");
        String desc = sc.nextLine();
        System.out.print("Rendimento mensal fixo (ex: 0.01 = 1%): ");
        double rm = lerDouble();
        System.out.print("Carência em dias: ");
        int car = lerInt();

        Produto p = new ProdutoRendaFixa(id, nome, desc, rm, car);
        repo.produtos.put(id, p);
        System.out.println("Produto RF criado ID " + id);
    }

    private static void criarRendaVariavel() {
        int id = repo.seqProduto.getAndIncrement();

        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Descrição: ");
        String desc = sc.nextLine();
        System.out.print("Rendimento mensal esperado (ex: 0.03 = 3%): ");
        double rm = lerDouble();

        Produto p = new ProdutoRendaVariavel(id, nome, desc, rm);
        repo.produtos.put(id, p);
        System.out.println("Produto RV criado ID " + id);
    }

    private static void listarProdutos() {
        System.out.println("\nProdutos:");
        if (repo.produtos.isEmpty()) {
            System.out.println("(vazio)");
            return;
        }
        for (Produto p : repo.produtos.values()) {
            System.out.println(p + " | " + p.getDescricao());
        }
    }

    private static void atualizarProduto() {
        listarProdutos();
        System.out.print("ID do produto: ");
        int id = lerInt();
        Produto p = repo.produtos.get(id);
        if (p == null) {
            System.out.println("Produto não encontrado.");
            return;
        }
        System.out.print("Novo nome: ");
        String nome = sc.nextLine();
        System.out.print("Nova descrição: ");
        String desc = sc.nextLine();
        p.setNome(nome);
        p.setDescricao(desc);
        System.out.println("Atualizado.");
    }

    private static void removerProduto() {
        listarProdutos();
        System.out.print("ID do produto para remover: ");
        int id = lerInt();
        Produto removido = repo.produtos.remove(id);
        if (removido == null) System.out.println("Produto não encontrado.");
        else System.out.println("Removido: " + removido);
    }

    private static void criarContaInvestAuto(Cliente c) {
        if (repo.produtos.isEmpty()) {
            System.out.println("Cadastre produtos primeiro.");
            return;
        }

        System.out.print("Saldo inicial: ");
        double saldoInicial = lerDouble();

        ContaInvestimentoAutomatico conta = new ContaInvestimentoAutomatico(repo.seqConta.getAndIncrement(), saldoInicial);

        System.out.println("Definir alocações (soma recomendada ~ 1.0).");
        listarProdutos();

        List<Alocacao> alocs = new ArrayList<>();

        System.out.print("Quantos produtos na alocação? ");
        int qtd = lerInt();

        for (int i = 0; i < qtd; i++) {
            System.out.print("ID do produto: ");
            int idProd = lerInt();
            Produto p = repo.produtos.get(idProd);
            if (p == null) {
                System.out.println("Produto inválido. Ignorado.");
                i--;
                continue;
            }
            System.out.print("Percentual (ex: 0.5): ");
            double perc = lerDouble();
            try {
                alocs.add(new Alocacao(p, perc));
            } catch (Exception e) {
                System.out.println("Erro na alocação: " + e.getMessage());
                i--;
            }
        }

        conta.definirAlocacoes(alocs);
        c.adicionarConta(conta);
        System.out.println("Conta Invest. Automático criada: " + conta);
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

    private static void seed() {
        int p1 = repo.seqProduto.getAndIncrement();
        repo.produtos.put(p1, new ProdutoRendaFixa(p1, "CDB 110%", "Renda fixa com carência", 0.012, 90));

        int p2 = repo.seqProduto.getAndIncrement();
        repo.produtos.put(p2, new ProdutoRendaVariavel(p2, "Fundo Ações XPTO", "Renda variável (esperado)", 0.03));

        int c1 = repo.seqCliente.getAndIncrement();
        PessoaFisica pf = new PessoaFisica(c1, "Cliente PF", "000.000.000-00", "pf@email.com");
        pf.adicionarConta(new ContaCDI(repo.seqConta.getAndIncrement(), 10000));
        repo.clientes.put(c1, pf);

        int c2 = repo.seqCliente.getAndIncrement();
        PessoaJuridica pj = new PessoaJuridica(c2, "Cliente PJ", "00.000.000/0001-00", "pj@email.com");

        ContaInvestimentoAutomatico inv = new ContaInvestimentoAutomatico(repo.seqConta.getAndIncrement(), 20000);
        List<Alocacao> al = new ArrayList<>();
        al.add(new Alocacao(repo.produtos.get(p1), 0.6));
        al.add(new Alocacao(repo.produtos.get(p2), 0.4));
        inv.definirAlocacoes(al);

        pj.adicionarConta(inv);
        repo.clientes.put(c2, pj);
    }
}