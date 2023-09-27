package br.com.mrocha.dao.jpa;

import br.com.mrocha.dao.generic.jpa.GenericJpaDAOMySQL;
import br.com.mrocha.domain.jpa.ClienteJpaMySQL;

public class ClienteJpaDAOMySQL extends GenericJpaDAOMySQL<ClienteJpaMySQL, Long> implements IClienteJpaDAO<ClienteJpaMySQL> {

    public ClienteJpaDAOMySQL() {
        super(ClienteJpaMySQL.class);
    }
}
