package br.com.mrocha.dao.generic.jpa;

import br.com.mrocha.exceptions.DAOException;
import br.com.mrocha.exceptions.MaisDeUmRegistroException;
import br.com.mrocha.exceptions.TableException;
import br.com.mrocha.exceptions.TipoChaveNaoEncontradaException;
import jakarta.persistence.Persistence;

import java.io.Serializable;
import java.util.Collection;

public interface IGenericJpaDAO <T extends Persistence, E extends Serializable> {

    T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    void excluir(T entity) throws DAOException;

    T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    T consultar(E id) throws MaisDeUmRegistroException, TableException, DAOException;

    Collection<T> buscarTodos() throws DAOException;
}
