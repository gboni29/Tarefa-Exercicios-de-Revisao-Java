package Bloco_8;

import java.lang.reflect.Field;

public class exercicio02 {

    static class Configuracao {
        private String urlConexao = "localhost:5432";
    }

    public static void main(String[] args) throws Exception {

        Configuracao cfg = new Configuracao();

        Field field = Configuracao.class.getDeclaredField("urlConexao");
        field.setAccessible(true);

        field.set(cfg, "db.producao.com:5432");

        Object valor = field.get(cfg);
        System.out.println("urlConexao = " + valor);
    }
}
