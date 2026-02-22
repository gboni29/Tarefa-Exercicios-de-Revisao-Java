package Bloco_8;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

public class exercicio03 {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface Teste {
    }

    static class MinhaClasseDeTeste {

        @Teste
        public void testeSoma() {
            System.out.println("Executando testeSoma: SUCESSO");
        }

        public void metodoComum() {
            System.out.println("Este não é um teste.");
        }

        @Teste
        public void testeLogin() {
            System.out.println("Executando testeLogin: SUCESSO");
        }
    }

    static class ExecutorDeTestes {

        public static void executarTestes(Object obj) throws Exception {
            Class<?> clazz = obj.getClass();
            Method[] metodos = clazz.getDeclaredMethods();

            for (Method m : metodos) {
                if (m.isAnnotationPresent(Teste.class)) {
                    m.setAccessible(true);
                    m.invoke(obj);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        MinhaClasseDeTeste testes = new MinhaClasseDeTeste();
        ExecutorDeTestes.executarTestes(testes);
    }
}
