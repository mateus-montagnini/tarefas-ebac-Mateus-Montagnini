package br.com.mrocha.services.generic.jpa;

import br.com.mrocha.dao.Persistente;
import br.com.mrocha.dao.generic.jpa.IGenericJpaDAO;
import br.com.mrocha.exceptions.DAOException;
import br.com.mrocha.exceptions.MaisDeUmRegistroException;
import br.com.mrocha.exceptions.TableException;
import br.com.mrocha.exceptions.TipoChaveNaoEncontradaException;
import jakarta.persistence.Persistence;

import java.io.Serializable;
import java.util.Collection;

public class GenericJpaService <T extends Persistence & Persistente, E extends Serializable> implements IGenericJpaService<T, E> {

    protected IGenericJpaDAO<T, E> genericJpaDAO;

    public GenericJpaService(IGenericJpaDAO<T, E> dao) {
        this.genericJpaDAO = dao;
    }


    @Override
    public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        return this.genericJpaDAO.cadastrar(entity);
    }

    @Override
    public void excluir(T entity) throws DAOException {
        this.genericJpaDAO.excluir(entity);
    }

    @Override
    public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        return this.genericJpaDAO.alterar(entity);
    }

    @Override
    public T consultar(E id) throws MaisDeUmRegistroException, TableException, DAOException {
        return this.genericJpaDAO.consultar(id);
    }

    @Override
    public Collection<T> buscarTodos() throws DAOException {
        return this.genericJpaDAO.buscarTodos();
    }
}
