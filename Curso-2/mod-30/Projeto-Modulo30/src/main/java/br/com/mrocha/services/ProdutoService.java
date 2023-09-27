package main.java.br.com.mrocha.services;

import main.java.br.com.mrocha.dao.IProdutoDAO;
import main.java.br.com.mrocha.domain.Produto;
import main.java.br.com.mrocha.exceptions.DAOException;
import main.java.br.com.mrocha.exceptions.TipoChaveNaoEncontradaException;
import main.java.br.com.mrocha.services.generic.GenericService;

import java.util.Collection;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}
}
