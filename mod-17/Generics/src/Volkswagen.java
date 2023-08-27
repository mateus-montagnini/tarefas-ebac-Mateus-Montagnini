public class Volkswagen<T> extends Car {

    @Override
    public T criaListaDeCarros() {
        setFabrica("Volkswagen");
        lista.add(getFabrica());
        setModelo("Polo");
        lista.add(getModelo());
        setPlaca("JUOQ-5032");
        lista.add(getPlaca());
        setCor("Prata");
        lista.add(getCor());
        return (T) lista;
    }
}
