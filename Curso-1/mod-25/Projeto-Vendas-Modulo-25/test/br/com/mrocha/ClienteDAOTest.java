package br.com.mrocha;

import main.domain.Cliente;
import main.dao.IClienteDAO;
import main.exception.TipoChaveNaoEncontradaException;
import main.mocks.ClienteDaoMock;


import static org.junit.Assert.assertTrue;

import java.util.Collection;

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
    public void init() throws TipoChaveNaoEncontradaException {
        cliente = new Cliente();
        cliente.setCpf(1234567890L);
        cliente.setNome("Mateus");
        cliente.setCidade("Sao Paulo");
        cliente.setEnd("End");
        cliente.setEstado("SP");
        cliente.setNumero(10);
        cliente.setTel(11999322143L);

        iClienteDAO.cadastrar(cliente);
    }

    @Test
    public void pesquisarCliente() {

        Cliente clienteConsultado = iClienteDAO.consultar(cliente.getCpf());

        Assert.assertNotNull(clienteConsultado);

    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        Boolean retorno = iClienteDAO.cadastrar(cliente);
        assertTrue(retorno);
    }

    @Test
    public void excluirCliente() {
        iClienteDAO.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Mateus");
        iClienteDAO.alterar(cliente);

        Assert.assertEquals("Mateus", cliente.getNome());
    }
}