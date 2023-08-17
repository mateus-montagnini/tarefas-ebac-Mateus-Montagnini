import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um valor int:");
        int valorI = sc.nextInt();
        System.out.println("Digite um valor double:");
        double valorD = sc.nextDouble();
        System.out.println("Digite um valor long:");
        long valorL = sc.nextLong();

        System.out.println(valorI);
        System.out.println(valorD);
        System.out.println(valorL);

        Integer valorInteger = valorI;
        Double valorDouble = valorD;
        Long valorLong = valorL;

        System.out.println(valorInteger);
        System.out.println(valorDouble);
        System.out.println(valorLong);
    }
}
