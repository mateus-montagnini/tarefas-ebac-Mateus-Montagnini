
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        List<String> lista;

        Pessoa p1 = new Pessoa("Mateus", 'M');
        Pessoa p2 = new Pessoa("Lucas", 'M');
        Pessoa p3 = new Pessoa("Juliana", 'F');
        Pessoa p4 = new Pessoa("Bianca", 'F');
        Pessoa p5 = new Pessoa("Fernando", 'M');
        Pessoa p6 = new Pessoa("Isabela", 'F');

        pessoa.cadastrarPessoa(p1);
        pessoa.cadastrarPessoa(p2);
        pessoa.cadastrarPessoa(p3);
        pessoa.cadastrarPessoa(p4);
        pessoa.cadastrarPessoa(p5);
        pessoa.cadastrarPessoa(p6);

        lista = pessoa.getLista();


        List<String> listaFeminina = lista.stream()
                .filter(p -> p.endsWith("-F"))
                .toList();


        System.out.println("Lista completa: " + lista);
        System.out.println("Lista de mulheres: " + listaFeminina);
    }
}
