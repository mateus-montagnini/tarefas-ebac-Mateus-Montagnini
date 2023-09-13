package br.com.mrocha.dao.jpa;

import br.com.mrocha.dao.generic.jpa.GenericJpaDAO;
import br.com.mrocha.domain.jpa.ClienteJpa;

public class ClienteJpaDAO extends GenericJpaDAO<ClienteJpa, Long> implements IClienteJpaDAO {

    public ClienteJpaDAO() {
        super(ClienteJpa.class);
    }
}
