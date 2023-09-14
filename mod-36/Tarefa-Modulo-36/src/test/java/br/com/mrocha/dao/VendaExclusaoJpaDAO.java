package br.com.mrocha.dao;

import br.com.mrocha.dao.generic.jpa.GenericJpaDAO;
import br.com.mrocha.dao.jpa.IVendaJpaDAO;
import br.com.mrocha.domain.jpa.VendaJpa;
import br.com.mrocha.exceptions.DAOException;
import br.com.mrocha.exceptions.TipoChaveNaoEncontradaException;

public class VendaExclusaoJpaDAO extends GenericJpaDAO<VendaJpa, Long> implements IVendaJpaDAO {

    public VendaExclusaoJpaDAO() {
        super(VendaJpa.class);
    }

    @Override
    public void finalizarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException {
        throw new UnsupportedOperationException("Operacao nao permitida");
    }

    @Override
    public void cancelarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException {
        throw new UnsupportedOperationException("Operacao nao permitida");
    }

    @Override
    public VendaJpa consultarVenda(Long id) {
        throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
    }

}
