package br.com.mrocha.dao;

import java.util.List;

import br.com.mrocha.dao.generic.IGenericDAO;
import br.com.mrocha.domain.Produto;

public interface IProdutoDAO extends IGenericDAO<Produto, String>{

	List<Produto> filtrarProdutos(String query);

}
