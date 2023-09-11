import br.mrocha.dao.*;
import br.mrocha.domain.Acessorio;
import br.mrocha.domain.Carro;
import br.mrocha.domain.Marca;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CarroTeste {

    private ICarroDAO carroDAO;
    private IAcessorioDAO acessorioDAO;
    private IMarcaDAO marcaDAO;

    public CarroTeste() {
        carroDAO = new CarroDAO();
        acessorioDAO = new AcessorioDAO();
        marcaDAO = new MarcaDAO();
    }

    @Test
    public void testeCriarCarro() {
        Acessorio acessorio = criarAcessorio("A1", "Automatico");
        Marca marca = criarMarca("A1");

        Carro carro = new Carro();
        carro.setCodigo("A1");
        carro.setModelo("Fiesta");
        carro.setPlaca("ABCD-1234");
        carro.setAno(2010);
        carro.setMarca(marca);

        carro = carroDAO.criarCarro(carro);
        assertNotNull(carro);
        assertNotNull(carro.getId());

        Carro carroBD = carroDAO.buscarPorCodigo(carro.getCodigo());
        assertNotNull(carroBD);
        assertEquals(carro.getId(), carroBD.getId());
    }

    private Acessorio criarAcessorio(String codigo, String feat) {
        Acessorio acessorio = new Acessorio();
        acessorio.setCodigo(codigo);
        acessorio.setDescricao(feat);

        return acessorioDAO.adicionarAcessorio(acessorio);
    }

    private Marca criarMarca(String codigo) {
        Marca marca = new Marca();
        marca.setCodigo(codigo);
        marca.setNome("Ford");
        return marcaDAO.criarMarca(marca);
    }
}
