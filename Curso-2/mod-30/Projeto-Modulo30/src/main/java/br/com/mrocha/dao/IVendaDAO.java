package main.java.br.com.mrocha.dao;

import main.java.br.com.mrocha.dao.generic.IGenericDAO;
import main.java.br.com.mrocha.domain.Venda;
import main.java.br.com.mrocha.exceptions.DAOException;
import main.java.br.com.mrocha.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, String> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
