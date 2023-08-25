public class Volkswagen extends Car {

    @Override
    public Object criaListaDeCarros() {
        setFabrica("Volkswagen");
        lista.add(getFabrica());
        setModelo("Polo");
        lista.add(getModelo());
        setPlaca("JUOQ-5032");
        lista.add(getPlaca());
        setCor("Prata");
        lista.add(getCor());
        return lista;
    }
}
