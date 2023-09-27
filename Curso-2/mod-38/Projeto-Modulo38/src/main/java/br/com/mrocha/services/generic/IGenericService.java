package br.com.mrocha.services.generic;

import java.io.Serializable;
import java.util.Collection;

import br.com.mrocha.domain.Persistente;
import br.com.mrocha.exceptions.DAOException;
import br.com.mrocha.exceptions.MaisDeUmRegistroException;
import br.com.mrocha.exceptions.TableException;
import br.com.mrocha.exceptions.TipoChaveNaoEncontradaException;

public interface IGenericService <T extends Persistente, E extends Serializable> {
	
    T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException;
    T consultar(E valor) throws MaisDeUmRegistroException, TableException, DAOException;
    T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException;
    void excluir(T entity) throws DAOException;
    Collection<T> buscarTodos() throws DAOException;

}
