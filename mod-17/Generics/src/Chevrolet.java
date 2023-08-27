import java.util.List;

public class Chevrolet<T> extends Car {

    @Override
    public List<T> criaListaDeCarros() {
        setFabrica("Chevrolet");
        lista.add(getFabrica());
        setModelo("Corsa");
        lista.add(getModelo());
        setAnoDeFabricacao(2010);
        lista.add(getAnoDeFabricacao());
        setPlaca("SPRW-1048");
        lista.add(getPlaca());
        setCor("Branco");
        lista.add(getCor());
        return lista;
    }
}
