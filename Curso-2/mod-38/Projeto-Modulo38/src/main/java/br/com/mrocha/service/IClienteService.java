package br.com.mrocha.service;

import java.util.List;

import br.com.mrocha.dao.generic.IGenericDAO;
import br.com.mrocha.domain.Cliente;
import br.com.mrocha.exceptions.DAOException;
import br.com.mrocha.services.generic.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {

	Cliente buscarPorCPF(Long cpf) throws DAOException;

	List<Cliente> filtrarClientes(String query);

}
