package br.com.mrocha;

import br.com.mrocha.dao.ClienteDAO;
import br.com.mrocha.dao.mocks.ClienteMock;
import br.com.mrocha.dao.IClienteDAO;
import br.com.mrocha.service.ClienteService;
import org.junit.Assert;
import org.junit.Test;

public class ClienteServiceTest {

    @Test
    public void salvarTest() {
        IClienteDAO mockDao = new ClienteMock();
        ClienteService service = new ClienteService(mockDao);
        String retorno = service.salvar();
        Assert.assertEquals("Cliente salvo com sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoSalvarTest() {
        IClienteDAO dao = new ClienteDAO();
        ClienteService service = new ClienteService(dao);
        String retorno = service.salvar();
        Assert.assertEquals("Cliente salvo com sucesso", retorno);
    }

    @Test
    public void buscarTest() {
        IClienteDAO mockDao = new ClienteMock();
        ClienteService service = new ClienteService(mockDao);
        String retorno = service.buscar();
        Assert.assertEquals("Busca realizada com sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoBuscarTest() {
        IClienteDAO dao = new ClienteDAO();
        ClienteService service = new ClienteService(dao);
        String retorno = service.buscar();
        Assert.assertEquals("Busca realizada com sucesso", retorno);
    }

    @Test
    public void excluirTest() {
        IClienteDAO mockDao = new ClienteMock();
        ClienteService service = new ClienteService(mockDao);
        String retorno = service.excluir();
        Assert.assertEquals("Cliente excluido com sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoExcluirTest() {
        IClienteDAO dao = new ClienteDAO();
        ClienteService service = new ClienteService(dao);
        String retorno = service.excluir();
        Assert.assertEquals("Cliente excluido com sucesso", retorno);
    }

    @Test
    public void atualizarTest() {
        IClienteDAO mockDao = new ClienteMock();
        ClienteService service = new ClienteService(mockDao);
        String retorno = service.atualizar();
        Assert.assertEquals("Cliente atualizado com sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoAtualizarTest() {
        IClienteDAO dao = new ClienteDAO();
        ClienteService service = new ClienteService(dao);
        String retorno = service.atualizar();
        Assert.assertEquals("Cliente atualizado com sucesso", retorno);
    }
}
