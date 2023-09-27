package br.com.mrocha.service;

import java.util.Collection;
import java.util.List;

import br.com.mrocha.domain.Produto;
import br.com.mrocha.services.generic.IGenericService;

public interface IProdutoService extends IGenericService<Produto, String> {

	List<Produto> filtrarProdutos(String query);
	
}
