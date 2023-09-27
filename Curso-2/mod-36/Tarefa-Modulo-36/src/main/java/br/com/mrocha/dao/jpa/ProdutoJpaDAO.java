package br.com.mrocha.dao.jpa;

import br.com.mrocha.dao.generic.jpa.GenericJpaDAO;
import br.com.mrocha.domain.jpa.ProdutoJpa;

public class ProdutoJpaDAO extends GenericJpaDAO<ProdutoJpa, Long> implements IProdutoJpaDAO {

    public ProdutoJpaDAO() {
        super(ProdutoJpa.class);
    }
}
