package br.com.mrocha.dao.jpa;

import br.com.mrocha.dao.generic.jpa.IGenericJpaDAO;
import br.com.mrocha.domain.jpa.VendaJpa;
import br.com.mrocha.exceptions.DAOException;
import br.com.mrocha.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaJpaDAO extends IGenericJpaDAO<VendaJpa, Long> {

    void finalizarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException;

    void cancelarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException;

    VendaJpa consultarVenda(Long id);
}
