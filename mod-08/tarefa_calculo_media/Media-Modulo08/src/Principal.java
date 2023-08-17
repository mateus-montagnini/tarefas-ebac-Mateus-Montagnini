import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        CalculoMedia calculo = new CalculoMedia();
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a primeira nota:");
        int nota1 = sc.nextInt();
        System.out.println("Digite a seguunda nota:");
        int nota2 = sc.nextInt();
        System.out.println("Digite a terceira nota:");
        int nota3 = sc.nextInt();
        System.out.println("Digite a quarta nota:");
        int nota4 = sc.nextInt();

        double media = calculo.calcularMedia(nota1, nota2, nota3, nota4);

        System.out.println("A média do estudante é: " + media);

    }
}
