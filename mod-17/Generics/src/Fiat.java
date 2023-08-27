public class Fiat<T> extends Car {

    @Override
    public T criaListaDeCarros() {
        setFabrica("Fiat");
        lista.add(getFabrica());
        setModelo("Uno");
        lista.add(getModelo());
        setPlaca("ZNUM-9952");
        lista.add(getPlaca());
        setCor("Preto");
        lista.add(getCor());
        return (T) lista;
    }
}
