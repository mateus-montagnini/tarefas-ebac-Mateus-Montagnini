import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> lista = new ArrayList<>();


        System.out.println("Deseja adicionar uma pessoa?");
        String resposta = sc.nextLine();

        while (resposta.equalsIgnoreCase("Sim")) {
            System.out.println("Digite o nome e o sexo da pessoa (Carlos-M):");
            String pessoa = sc.nextLine();
            lista.add(pessoa);
            System.out.println("Deseja adicionar outra pessoa?");
            resposta = sc.nextLine();
        }

        List<String> listaStream = lista.stream()
                    .filter(pessoa -> pessoa.endsWith("-F"))
                    .collect(Collectors.toList());

        System.out.println("Lista completa: " + lista);
        System.out.println("Lista de mulheres: " + listaStream);

    }
}