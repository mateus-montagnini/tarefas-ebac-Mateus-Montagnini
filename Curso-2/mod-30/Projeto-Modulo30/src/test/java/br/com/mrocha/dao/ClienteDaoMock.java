package test.java.br.com.mrocha.dao;

import main.java.br.com.mrocha.dao.IClienteDAO;
import main.java.br.com.mrocha.domain.Cliente;
import main.java.br.com.mrocha.exceptions.TipoChaveNaoEncontradaException;

import java.util.Collection;


public class ClienteDaoMock implements IClienteDAO {

	@Override
	public Boolean cadastrar(Cliente entity) throws TipoChaveNaoEncontradaException {
		return true;
	}

	@Override
	public void excluir(Long valor) {
	}

	@Override
	public void alterar(Cliente entity) throws TipoChaveNaoEncontradaException {
	}

	@Override
	public Cliente consultar(Long valor) {
		Cliente cliente = new Cliente();
		cliente.setCpf(valor);
		return cliente;
	}

	@Override
	public Collection<Cliente> buscarTodos() {
		return null;
	}


}
