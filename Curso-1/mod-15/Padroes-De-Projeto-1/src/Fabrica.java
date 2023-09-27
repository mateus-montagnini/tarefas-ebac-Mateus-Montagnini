public abstract class Fabrica {
    public Car criarCarro(String modelo) {
        Car carro = entregarCarro(modelo);
        return carro;
    }

    abstract Car entregarCarro(String modelo);
}
