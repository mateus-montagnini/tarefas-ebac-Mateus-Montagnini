package br.com.mrocha.dao.generic;

import java.io.Serializable;
import java.util.Collection;

import br.com.mrocha.domain.Persistente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;



public class GenericDAO <T extends Persistente, E extends Serializable> implements IGenericDAO <T,E> {
	
	protected Class<T> persistenteClass;
	
	@PersistenceContext
    protected EntityManager entityManager;
	
	public GenericDAO(Class<T> persistenteClass) {
		this.persistenteClass = persistenteClass;
	}
	
	@Override
	public T cadastrar(T entity) {
		entityManager.persist(entity);
		return entity;
	}

	@Override
	public void excluir(T entity) {
		if (entityManager.contains(entity)) {
            entityManager.remove(entity);
        } else {
            T managedCustomer = entityManager.find(this.persistenteClass, entity.getId());
            if (managedCustomer != null) {
                entityManager.remove(managedCustomer);
            }
        }
		
	}

	@Override
	public T alterar(T entity) {
		entity = entityManager.merge(entity);
		return entity;
	}

	@Override
	public T consultar(E valor) {
        return entityManager.find(this.persistenteClass, valor);
	}

	@Override
	public Collection<T> buscarTodos() {
        return entityManager.createQuery(getSql(), this.persistenteClass).getResultList();
	}
	
	private String getSql() {
        return "SELECT obj FROM " +
				this.persistenteClass.getSimpleName() +
				" obj";
	}


}
