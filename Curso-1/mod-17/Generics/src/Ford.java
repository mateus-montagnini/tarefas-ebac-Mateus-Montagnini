import java.util.List;

public class Ford<T> extends Car {

    @Override
    public List<T> criaListaDeCarros() {
        setFabrica("Ford");
        lista.add(getFabrica());
        setModelo("Fiesta");
        lista.add(getModelo());
        setAnoDeFabricacao(2014);
        lista.add(getAnoDeFabricacao());
        setPlaca("LKKN-9247");
        lista.add(getPlaca());
        setCor("Azul");
        lista.add(getCor());
        return lista;
    }
}
