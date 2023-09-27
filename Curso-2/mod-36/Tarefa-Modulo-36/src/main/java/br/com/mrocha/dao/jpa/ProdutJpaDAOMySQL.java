package br.com.mrocha.dao.jpa;

import br.com.mrocha.dao.IProdutoDAO;
import br.com.mrocha.dao.generic.jpa.GenericJpaDAOMySQL;
import br.com.mrocha.domain.jpa.ClienteJpaMySQL;
import br.com.mrocha.domain.jpa.ProdutoJpaMySQL;

public class ProdutJpaDAOMySQL extends GenericJpaDAOMySQL<ProdutoJpaMySQL, Long> implements IProdutoDAO<ProdutoJpaMySQL> {

    public ProdutJpaDAOMySQL() {
        super(ProdutoJpaMySQL.class);
    }
}
