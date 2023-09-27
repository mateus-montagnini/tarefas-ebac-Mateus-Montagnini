import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CalcularMedia calculo = new CalcularMedia();
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a primeira nota:");
        double n1 = sc.nextDouble();
        System.out.println("Digite a segunda nota:");
        double n2 = sc.nextDouble();
        System.out.println("Digite a terceira nota:");
        double n3 = sc.nextDouble();
        System.out.println("Digite a quarta nota:");
        double n4 = sc.nextDouble();

        double media = calculo.calculoMedia(n1, n2, n3, n4);

        String resultado;
        if (media >= 7) {
            resultado = "aprovado";
        } else if (media >= 5) {
            resultado = "de recuperação";
        } else {
            resultado = "reprovado";
        }

        System.out.println("A média do estudante é: " + media + "\nO estudante está " + resultado);

        sc.close();
    }
}