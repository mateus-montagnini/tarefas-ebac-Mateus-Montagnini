import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsCollectionContaining.hasItems;

public class TestLista {
    List<String> listaFeminina = new ArrayList<>();

    @Test
    public void listaTest() {
        Pessoa pessoa = new Pessoa(List.of("Mateus-M", "Juliana-F", "Caio-M", "Beatriz-F", "Sofia-F", "Ronaldo-M"));

        listaFeminina = pessoa.atualizarLista(pessoa.getLista());

        Assert.assertThat(listaFeminina,
                hasItems("Juliana-F", "Beatriz-F", "Sofia-F"));
        }
    }
