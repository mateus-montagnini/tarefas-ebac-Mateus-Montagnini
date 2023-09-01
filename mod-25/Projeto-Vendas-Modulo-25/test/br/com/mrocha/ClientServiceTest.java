package br.com.mrocha;

import main.Cliente;
import main.dao.IClienteDAO;
import main.mocks.ClienteDaoMock;
import main.services.ClienteService;
import main.services.IClienteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClientServiceTest {

    private IClienteService iClienteService;
    private Cliente cliente;

    public  ClientServiceTest() {
        IClienteDAO dao = new ClienteDaoMock();
        iClienteService = new ClienteService(dao);
    }

    @Before
    public void init() {
        cliente = new Cliente();
        cliente.setCpf(1234567890L);
        cliente.setNome("Mateus");
        cliente.setCidade("Sao Paulo");
        cliente.setEnd("End");
        cliente.setEstado("SP");
        cliente.setNumero(10);
        cliente.setTel(11999322143L);

        iClienteService.salvar(cliente);
    }

    @Test
    public void pesquisarCliente() {

        Cliente clienteConsultado = iClienteService.buscarPorCpf(cliente.getCpf());

        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() {
        Boolean retorno = iClienteService.salvar(cliente);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente() {
        iClienteService.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() {
        cliente.setNome("Mateus");
        iClienteService.alterar(cliente);

        Assert.assertEquals( "Mateus", cliente.getNome());
    }
}
