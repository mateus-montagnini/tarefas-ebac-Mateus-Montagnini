package br.com.mrocha.services;


import br.com.mrocha.domain.Cliente;
import br.com.mrocha.exceptions.DAOException;
import br.com.mrocha.services.generic.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {

	Cliente buscarPorCPF(Long cpf) throws DAOException;
}
