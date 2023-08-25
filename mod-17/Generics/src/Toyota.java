public class Toyota extends Car {

    @Override
    public Object criaListaDeCarros() {
        setFabrica("Toyota");
        lista.add(getFabrica());
        setModelo("Corolla");
        lista.add(getModelo());
        setPlaca("ADQZ-1432");
        lista.add(getPlaca());
        setCor("Verde");
        lista.add(getCor());
        return lista;
    }
}
