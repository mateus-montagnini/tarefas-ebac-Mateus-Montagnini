package br.com.mrocha.services;

import br.com.mrocha.dao.IProdutoDAO;
import br.com.mrocha.domain.Produto;
import br.com.mrocha.exceptions.DAOException;
import br.com.mrocha.exceptions.TipoChaveNaoEncontradaException;
import br.com.mrocha.services.generic.GenericService;

import java.util.Collection;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}
}
