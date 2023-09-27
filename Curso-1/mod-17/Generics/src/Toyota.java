import java.util.List;

public class Toyota<T> extends Car {

    @Override
    public List<T> criaListaDeCarros() {
        setFabrica("Toyota");
        lista.add(getFabrica());
        setModelo("Corolla");
        lista.add(getModelo());
        setAnoDeFabricacao(2012);
        lista.add(getAnoDeFabricacao());
        setPlaca("ADQZ-1432");
        lista.add(getPlaca());
        setCor("Verde");
        lista.add(getCor());
        return lista;
    }
}
