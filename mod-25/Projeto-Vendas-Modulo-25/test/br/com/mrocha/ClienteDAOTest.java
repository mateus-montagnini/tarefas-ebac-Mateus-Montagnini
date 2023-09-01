package br.com.mrocha;

import main.Cliente;
import main.dao.ClienteDAO;
import main.dao.IClienteDAO;
import main.mocks.ClienteDaoMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteDAOTest {
    private IClienteDAO iClienteDAO;
    private Cliente cliente;

    public ClienteDAOTest() {
        iClienteDAO = new ClienteDaoMock();
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

        iClienteDAO.salvar(cliente);
    }

    @Test
    public void pesquisarCliente() {

        Cliente clienteConsultado = iClienteDAO.buscarPorCpf(cliente.getCpf());

        Assert.assertNotNull(clienteConsultado);

    }

    @Test
    public void salvarCliente() {
        Boolean retorno = iClienteDAO.salvar(cliente);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente() {
        iClienteDAO.excluir(cliente.getCpf());
    }
}