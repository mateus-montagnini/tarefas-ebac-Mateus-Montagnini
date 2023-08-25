public class Chevrolet extends Car {

    @Override
    public Object criaListaDeCarros() {
        setFabrica("Chevrolet");
        lista.add(getFabrica());
        setModelo("Corsa");
        lista.add(getModelo());
        setPlaca("SPRW-1048");
        lista.add(getPlaca());
        setCor("Branco");
        lista.add(getCor());
        return lista;
    }
}
