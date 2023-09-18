package br.com.mrocha.dao;

import java.util.List;

import br.com.mrocha.dao.generic.GenericDAO;
import br.com.mrocha.domain.Cliente;
import jakarta.persistence.TypedQuery;

public class ClienteDAO extends GenericDAO<Cliente, Long> implements IClienteDAO {


	public ClienteDAO() {
		super(Cliente.class);
	}

	@Override
	public List<Cliente> filtrarClientes(String query) {
		TypedQuery<Cliente> tpQuery = this.entityManager.createNamedQuery("Cliente.findByNome", this.persistenteClass);
		tpQuery.setParameter("nome", "%" + query + "%");
        return tpQuery.getResultList();
	}
}
