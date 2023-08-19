import javax.swing.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] array = new String[5];

        System.out.println("Informe o nome e sexo de 5 pessoas (Mateus-M)");
        System.out.println("Digite o nome e sexo da primeira pessoa");
        array[0] = sc.nextLine();
        System.out.println("Digite o nome e sexo da segunda pessoa");
        array[1] = sc.nextLine();
        System.out.println("Digite o nome e sexo da terceira pessoa");
        array[2] = sc.nextLine();
        System.out.println("Digite o nome e sexo da quarta pessoa");
        array[3] = sc.nextLine();
        System.out.println("Digite o nome e sexo da quinta pessoa");
        array[4] = sc.nextLine();

        List<String> arrayM = new ArrayList<>();
        List<String> arrayF = new ArrayList<>();

        OrdenacaoArray ordenarArray = new OrdenacaoArray();

        ordenarArray.arrayOrdenado(array, arrayM, arrayF);

        System.out.println("Lista de pessoas do sexo masculino: " + arrayM);
        System.out.println("Lista de pessoas do sexo feminino: " + arrayF);

        sc.close();
    }
}
