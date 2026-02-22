package Bloco_9;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Repositorios {
    public final Map<Integer, Cliente> clientes = new HashMap<>();
    public final Map<Integer, Produto> produtos = new HashMap<>();

    public final AtomicInteger seqCliente = new AtomicInteger(1);
    public final AtomicInteger seqProduto = new AtomicInteger(1);
    public final AtomicInteger seqConta = new AtomicInteger(1001);
}
