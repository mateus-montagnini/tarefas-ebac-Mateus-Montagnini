package test.java.br.com.mrocha;

import main.java.br.com.mrocha.dao.IClienteDAO;
import main.java.br.com.mrocha.domain.Cliente;
import main.java.br.com.mrocha.exceptions.DAOException;
import main.java.br.com.mrocha.exceptions.TipoChaveNaoEncontradaException;
import main.java.br.com.mrocha.services.ClienteService;
import main.java.br.com.mrocha.services.IClienteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import test.java.br.com.mrocha.dao.ClienteDaoMock;


public class ClienteServiceTest {
	
	private IClienteService clienteService;
	
	private Cliente cliente;
	
	public ClienteServiceTest() {
		IClienteDAO dao = new ClienteDaoMock();
		clienteService = new ClienteService(dao);
	}
	
	@Before
	public void init() {
		cliente = new Cliente();
		cliente.setCpf(987654321L);
		cliente.setNome("Carlos");
		cliente.setCidade("Santo Andre");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setNumero(14);
		cliente.setTel(11987654321L);
		cliente.setCep(98765307L);
	}
	
	@Test
	public void pesquisarCliente() throws DAOException {
		Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
	}
	
	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		Boolean retorno = clienteService.cadastrar(cliente);
		
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluirCliente() throws DAOException {
		clienteService.excluir(cliente.getCpf());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		cliente.setNome("Mateus");
		clienteService.alterar(cliente);
		
		Assert.assertEquals("Mateus", cliente.getNome());
	}
}
