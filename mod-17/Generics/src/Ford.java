public class Ford extends Car {

    @Override
    public Object criaListaDeCarros() {
        setFabrica("Ford");
        lista.add(getFabrica());
        setModelo("Fiesta");
        lista.add(getModelo());
        setPlaca("LKKN-9247");
        lista.add(getPlaca());
        setCor("Azul");
        lista.add(getCor());
        return lista;
    }
}
