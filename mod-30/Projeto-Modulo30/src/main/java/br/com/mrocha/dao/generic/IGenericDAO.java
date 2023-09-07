package main.java.br.com.mrocha.dao.generic;

import main.java.br.com.mrocha.dao.Persistente;
import main.java.br.com.mrocha.exceptions.DAOException;
import main.java.br.com.mrocha.exceptions.MaisDeUmRegistroException;
import main.java.br.com.mrocha.exceptions.TableException;
import main.java.br.com.mrocha.exceptions.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.util.Collection;
public interface IGenericDAO <T extends Persistente, E extends Serializable> {

    Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    void excluir(E valor) throws DAOException;

    void alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    T consultar(E valor) throws MaisDeUmRegistroException, TableException, DAOException;

    Collection<T> buscarTodos() throws DAOException;
}
