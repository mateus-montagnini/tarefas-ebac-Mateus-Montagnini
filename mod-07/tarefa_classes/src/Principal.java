import java.util.Scanner;

/**
 * @author mateus.montagnini
 *
 * @version 1.0
 */
public class Principal {
    public static void main(String[] args) {
        Carro carro = new Carro();

        carro.setAnoFabricacao(2018);
        carro.setModelo("Focus");
        carro.setPlaca("ABC-1234");

        int ano = carro.getAnoFabricacao();
        String modelo = carro.getModelo();
        String placa = carro.getPlacaNew();

        System.out.println("Carro: " + modelo + "\nPlaca: " + placa + "\nAno de fabricacao: " + ano);
    }
}