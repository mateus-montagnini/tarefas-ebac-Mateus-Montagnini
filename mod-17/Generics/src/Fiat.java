import java.util.List;

public class Fiat<T> extends Car {

    @Override
    public List<T> criaListaDeCarros() {
        setFabrica("Fiat");
        lista.add(getFabrica());
        setModelo("Uno");
        lista.add(getModelo());
        setAnoDeFabricacao(2020);
        lista.add(getAnoDeFabricacao());
        setPlaca("ZNUM-9952");
        lista.add(getPlaca());
        setCor("Preto");
        lista.add(getCor());
        return lista;
    }
}
