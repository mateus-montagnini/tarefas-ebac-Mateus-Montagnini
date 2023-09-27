public class Main {
    public static void main(String[] args) {
        Class<?> classe = ClasseComAnotacao.class;

        if(classe.isAnnotationPresent(Tabela.class)) {
            Tabela anotacao = classe.getAnnotation(Tabela.class);
            String valorAnotacao = anotacao.value();
            System.out.println("O valor da anotacao: " + valorAnotacao);
        } else {
            System.out.println("A classe nao possui esta anotacao");
        }

    }
}