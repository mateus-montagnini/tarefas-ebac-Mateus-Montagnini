public class Main {
    public static void main(String[] args) {
        Car carroToyota = new Toyota();
        System.out.println(carroToyota.criaListaDeCarros());

        Car carroVolkswagen = new Volkswagen();
        System.out.println(carroVolkswagen.criaListaDeCarros());

        Car carroChevrolet = new Chevrolet();
        System.out.println(carroChevrolet.criaListaDeCarros());

        Car carroFord = new Ford();
        System.out.println(carroFord.criaListaDeCarros());

        Car carroFiat = new Fiat();
        System.out.println(carroFiat.criaListaDeCarros());
    }

}