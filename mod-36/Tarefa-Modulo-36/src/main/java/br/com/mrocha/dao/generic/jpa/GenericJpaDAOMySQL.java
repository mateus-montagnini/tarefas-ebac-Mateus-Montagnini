package br.com.mrocha.dao.generic.jpa;

import br.com.mrocha.dao.Persistente;
import jakarta.persistence.Persistence;

import java.io.Serializable;

public class GenericJpaDAOMySQL <T extends Persistente, E extends Serializable> extends GenericJpaDAO<T, E> {

    public GenericJpaDAOMySQL(Class<T> persistenteClass) {
        super(persistenteClass, "mysql-modulo36");
    }
}
