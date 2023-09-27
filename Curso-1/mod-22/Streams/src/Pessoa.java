import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    private String name;
    private char sexo;
    private String cadastro;
    private List<String> lista = new ArrayList<>();

    public Pessoa() {

    }

    public Pessoa(String name, char sexo) {
        this.name = name;
        this.sexo = sexo;
        cadastro = name + "-" + sexo;
    }

    public void cadastrarPessoa(Pessoa pessoa) {
        lista.add(pessoa.cadastro);
    }

    public String getCadastro() {
        return cadastro;
    }

    public List<String> getLista() {
        return lista;
    }

    @Override
    public String toString() {
        return cadastro;
    }
}
