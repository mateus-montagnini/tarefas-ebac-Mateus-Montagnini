public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Fiesta");
        Fabrica fabrica = getFabrica(cliente);
        Car carro = fabrica.criarCarro(cliente.getPedido());
        carro.modeloDoCarro();
        carro.ano();
        carro.placaDoCarro();
        carro.potenciaDoCarro();
    }

    public static Fabrica getFabrica(Cliente cliente) {
        return new FabricaFord();
    }
}