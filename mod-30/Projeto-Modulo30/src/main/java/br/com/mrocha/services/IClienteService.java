package main.java.br.com.mrocha.services;


import main.java.br.com.mrocha.domain.Cliente;
import main.java.br.com.mrocha.exceptions.DAOException;
import main.java.br.com.mrocha.services.generic.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {

	Cliente buscarPorCPF(Long cpf) throws DAOException;
}
