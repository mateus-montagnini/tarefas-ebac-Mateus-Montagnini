package br.com.mrocha.dao;

import java.util.List;

import br.com.mrocha.dao.generic.GenericDAO;
import br.com.mrocha.domain.Produto;
import jakarta.persistence.TypedQuery;



public class ProdutoDAO extends GenericDAO<Produto, String> implements IProdutoDAO {

	public ProdutoDAO() {
		super(Produto.class);
	}

	@Override
	public List<Produto> filtrarProdutos(String query) {
		TypedQuery<Produto> tpQuery = this.entityManager.createNamedQuery("Produto.findByNome", this.persistenteClass);
		tpQuery.setParameter("nome", "%" + query + "%");
        return tpQuery.getResultList();
	}

}