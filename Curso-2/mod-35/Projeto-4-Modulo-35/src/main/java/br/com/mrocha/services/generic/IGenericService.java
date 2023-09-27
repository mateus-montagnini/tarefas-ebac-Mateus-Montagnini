package br.com.mrocha.services.generic;
import br.com.mrocha.dao.Persistente;
import br.com.mrocha.exceptions.DAOException;
import br.com.mrocha.exceptions.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.util.Collection;

public interface IGenericService <T extends Persistente, E extends Serializable> {

    Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    void excluir(E valor) throws DAOException;

    void alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    T consultar(E valor) throws DAOException;

    Collection<T> buscarTodos() throws DAOException;

}
