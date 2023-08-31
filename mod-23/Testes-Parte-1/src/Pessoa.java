import java.util.List;

public class Pessoa {
    private List<String> lista;

    public Pessoa(List<String> lista) {
        this.lista = lista;
    }

    public List<String> getLista() {
        return lista;
    }

    public List<String> atualizarLista(List<String> lista) {
        return lista.stream()
                .filter(p -> p.endsWith("-F"))
                .toList();
    }
}
