public class Principal {
    public static void main(String[] args) {
        CalculoMedia calculo = new CalculoMedia();

        double media = calculo.calcularMedia(5, 5, 10, 8);

        System.out.println("A média do estudante é: " + media);

    }
}
