public class Ford<T> extends Car {

    @Override
    public T criaListaDeCarros() {
        setFabrica("Ford");
        lista.add(getFabrica());
        setModelo("Fiesta");
        lista.add(getModelo());
        setPlaca("LKKN-9247");
        lista.add(getPlaca());
        setCor("Azul");
        lista.add(getCor());
        return (T) lista;
    }
}
