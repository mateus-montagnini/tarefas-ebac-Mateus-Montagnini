package br.com.mrocha.dao;

import br.com.mrocha.dao.generic.IGenericDAO;
import br.com.mrocha.domain.Venda;
import br.com.mrocha.exceptions.DAOException;
import br.com.mrocha.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, String> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
