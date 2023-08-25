public class Fiat extends Car {

    @Override
    public Object criaListaDeCarros() {
        setFabrica("Fiat");
        lista.add(getFabrica());
        setModelo("Uno");
        lista.add(getModelo());
        setPlaca("ZNUM-9952");
        lista.add(getPlaca());
        setCor("Preto");
        lista.add(getCor());
        return lista;
    }
}
