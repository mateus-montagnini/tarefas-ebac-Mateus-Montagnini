package br.com.mrocha.service;

import br.com.mrocha.dao.IContratoDAO;

public class ContratoService implements IContratoService {

    private IContratoDAO iContratoDao;

    public ContratoService(IContratoDAO iContratoDAO) {
        this.iContratoDao = iContratoDAO;
    }

    @Override
    public String salvar() {
        iContratoDao.salvar();
        return "Contrato salvo com sucesso";
    }

    @Override
    public String buscar() {
        iContratoDao.buscar();
        return "Busca realizada com sucesso";
    }

    @Override
    public String excluir() {
        iContratoDao.excluir();
        return "Contrato excluido com sucesso";
    }

    @Override
    public String atualizar() {
        iContratoDao.atualizar();
        return "Contrato atualizado com sucesso";
    }
}
