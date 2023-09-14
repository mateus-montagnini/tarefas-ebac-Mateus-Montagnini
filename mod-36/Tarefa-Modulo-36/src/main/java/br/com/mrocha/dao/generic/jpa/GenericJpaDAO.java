package br.com.mrocha.dao.generic.jpa;

import br.com.mrocha.dao.Persistente;
import br.com.mrocha.exceptions.DAOException;
import br.com.mrocha.exceptions.MaisDeUmRegistroException;
import br.com.mrocha.exceptions.TableException;
import br.com.mrocha.exceptions.TipoChaveNaoEncontradaException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class GenericJpaDAO <T extends Persistente, E extends Serializable> implements IGenericJpaDAO<T, E> {

    private static final String PERSISTENCE_UNIT_NAME = "postgres-modulo36";
    protected EntityManagerFactory entityManagerFactory;
    protected EntityManager entityManager;
    private Class<T> persistenceClass;
    private String persistenceName;

    public GenericJpaDAO(Class<T> persistenceClass) {
        this.persistenceClass = persistenceClass;
    }

    public GenericJpaDAO(Class<T> persistenceClass, String persistenceName) {
        this.persistenceClass = persistenceClass;
        this.persistenceName = persistenceName;
    }

    @Override
    public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        openConnection();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        closeConnection();

        return entity;
    }

    @Override
    public void excluir(T entity) throws DAOException {
        openConnection();
        entity = entityManager.merge(entity);
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
        closeConnection();
    }

    @Override
    public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        openConnection();
        entity = entityManager.merge(entity);
        entityManager.getTransaction().commit();
        closeConnection();

        return entity;
    }

    @Override
    public T consultar(E id) throws MaisDeUmRegistroException, TableException, DAOException {
        openConnection();
        T entity = entityManager.find(this.persistenceClass, id);
        entityManager.getTransaction().commit();
        closeConnection();

        return entity;
    }

    @Override
    public Collection<T> buscarTodos() throws DAOException {
        openConnection();
        List<T> list = entityManager.createQuery(getSql(), this.persistenceClass).getResultList();
        closeConnection();

        return list;
    }

    protected void openConnection() {
        entityManagerFactory = Persistence.createEntityManagerFactory(getPersistenceUnitName());
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }

    protected void closeConnection() {
        entityManager.close();
        entityManagerFactory.close();
    }

    private String getSql() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT obj FROM ");
        sb.append(this.persistenceClass.getSimpleName());
        sb.append(" obj");
        return sb.toString();
    }

    private String getPersistenceUnitName() {
        if (persistenceName != null
                && !"".equals(persistenceName)) {
            return persistenceName;
        } else {
            return PERSISTENCE_UNIT_NAME;
        }
    }
}
