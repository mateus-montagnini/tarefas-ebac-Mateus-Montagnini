import java.util.List;

public class Main {
    public static void main(String[] args) {

        Pessoa l1 = new Pessoa(List.of("Mateus-M", "Lucas-M", "Juliana-F", "Bianca-F"));
        Pessoa l2 = new Pessoa(List.of("Carlos-M", "Luciana-F", "Juliana-F", "Bianca-F"));
        Pessoa l3 = new Pessoa(List.of("Ronaldo-M", "Lucas-M", "Juliana-F", "Marcelo-M"));


        System.out.println("Lista 1 completa: " + l1.getLista());
        System.out.println("Lista 1 feminina: " + l1.atualizarLista(l1.getLista()));


        System.out.println("\nLista 2 completa: " + l2.getLista());
        System.out.println("Lista 2 feminina: " + l1.atualizarLista(l2.getLista()));

        System.out.println("\nLista 3 completa: " + l3.getLista());
        System.out.println("Lista 3 feminina: " + l3.atualizarLista(l3.getLista()));
    }
}