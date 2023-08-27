import java.util.List;

public class Volkswagen<T> extends Car {

    @Override
    public List<T> criaListaDeCarros() {
        setFabrica("Volkswagen");
        lista.add(getFabrica());
        setModelo("Polo");
        lista.add(getModelo());
        setAnoDeFabricacao(2008);
        lista.add(getAnoDeFabricacao());
        setPlaca("JUOQ-5032");
        lista.add(getPlaca());
        setCor("Prata");
        lista.add(getCor());
        return lista;
    }
}
