package main.java.br.com.mrocha.services;

import main.java.br.com.mrocha.dao.IClienteDAO;
import main.java.br.com.mrocha.domain.Cliente;
import main.java.br.com.mrocha.exceptions.DAOException;
import main.java.br.com.mrocha.exceptions.MaisDeUmRegistroException;
import main.java.br.com.mrocha.exceptions.TableException;
import main.java.br.com.mrocha.services.generic.GenericService;

public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {

	public ClienteService(IClienteDAO clienteDAO) {
		super(clienteDAO);
	}

	@Override
	public Cliente buscarPorCPF(Long cpf) throws DAOException {
		try {
			return this.dao.consultar(cpf);
		} catch (MaisDeUmRegistroException | TableException e) {
			e.printStackTrace();
		}
		return null;
	}

}
