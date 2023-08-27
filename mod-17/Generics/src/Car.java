import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Iterator;

public abstract class Car<T> implements IGenericCar<T> {
    private T modelo;
    private T placa;
    private T cor;
    private T fabrica;
    protected List<T> lista = new ArrayList<T>();

    public T getModelo() {
        return modelo;
    }


    public T getPlaca() {
        return placa;
    }


    public T getCor() {
        return cor;
    }

    public T getFabrica() {
        return fabrica;
    }

    public void setModelo(T modelo) {
        this.modelo = modelo;
    }

    public void setPlaca(T placa) {
        this.placa = placa;
    }

    public void setCor(T cor) {
        this.cor = cor;
    }

    public void setFabrica(T fabrica) {
        this.fabrica = fabrica;
    }
}
