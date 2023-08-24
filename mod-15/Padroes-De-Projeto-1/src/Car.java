public abstract class Car {
    private String modelo;
    private int anoDoCarro;
    private int potencia;
    private String placa;

    public Car(String modelo, int anoDoCarro, int potencia, String placa) {
        this.anoDoCarro = anoDoCarro;
        this.potencia = potencia;
        this.modelo = modelo;
        this.placa = placa;
    }

    public void modeloDoCarro() {
        System.out.println("O modelo de carro " + modelo + " foi criado com sucesso");
    }

    public void ano() {
        System.out.println("Este modelo foi fabricado em: " + anoDoCarro);
    }

    public void potenciaDoCarro() {
        System.out.println("Este modelo tem " + potencia + " cavalos de potencia");
    }

    public void placaDoCarro() {
        System.out.println("O carro tem a placa: " + placa);
    }
}
