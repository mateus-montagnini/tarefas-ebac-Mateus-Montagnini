package br.com.mrocha.dao.jpa;

import br.com.mrocha.dao.Persistente;
import br.com.mrocha.dao.generic.jpa.IGenericJpaDAO;
import br.com.mrocha.domain.jpa.ClienteJpa;
import jakarta.persistence.Persistence;

public interface IClienteJpaDAO<T extends Persistente> extends IGenericJpaDAO<T, Long>{

}
