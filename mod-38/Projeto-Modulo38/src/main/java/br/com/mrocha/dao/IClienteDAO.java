package br.com.mrocha.dao;

import java.util.List;

import br.com.mrocha.dao.generic.IGenericDAO;
import br.com.mrocha.domain.Cliente;

public interface IClienteDAO extends IGenericDAO<Cliente, Long> {

	List<Cliente> filtrarClientes(String query);
}
