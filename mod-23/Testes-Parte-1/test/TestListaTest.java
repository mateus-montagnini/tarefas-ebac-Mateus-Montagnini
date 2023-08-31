import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestListaTest {

    List<String> listaCompleta = new ArrayList<>();
    List<String> listaFeminina = new ArrayList<>();

    @Test
    public void listaTest() {
        Pessoa pessoa = new Pessoa(List.of("Mateus-M", "Juliana-F", "Caio-M", "Beatriz-F", "Sofia-F", "Ronaldo-M"));

        listaCompleta = pessoa.getLista();
        listaFeminina = pessoa.atualizarLista(pessoa.getLista());

        Assert.assertNotEquals(listaCompleta, listaFeminina);
    }
}