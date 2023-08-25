import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Iterator;

public abstract class Car<T> implements IGenericCar {
    private String modelo;
    private String placa;
    private String cor;
    private String fabrica;
    protected List<T> lista = new ArrayList<T>();

//    public Car(String modelo, String placa, String cor) {
//        this.modelo = modelo;
//        this.placa = placa;
//        this.cor = cor;
//    }

    public String getModelo() {
        return modelo;
    }


    public String getPlaca() {
        return placa;
    }


    public String getCor() {
        return cor;
    }

    public String getFabrica() {
        return fabrica;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setFabrica(String fabrica) {
        this.fabrica = fabrica;
    }
}
