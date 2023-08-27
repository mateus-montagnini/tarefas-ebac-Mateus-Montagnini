import java.util.List;

public class Chevrolet<T> extends Car {

    @Override
    public T criaListaDeCarros() {
        setFabrica("Chevrolet");
        lista.add(getFabrica());
        setModelo("Corsa");
        lista.add(getModelo());
        setPlaca("SPRW-1048");
        lista.add(getPlaca());
        setCor("Branco");
        lista.add(getCor());
        return (T) lista;
    }
}
