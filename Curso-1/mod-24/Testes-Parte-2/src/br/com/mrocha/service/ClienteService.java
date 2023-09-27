package br.com.mrocha.service;

import br.com.mrocha.dao.IClienteDAO;

public class ClienteService implements IClienteService {

    private IClienteDAO iClienteDao;

    public ClienteService(IClienteDAO iClienteDao) {
        this.iClienteDao = iClienteDao;
    }


    @Override
    public String salvar() {
        iClienteDao.salvar();
        return "Cliente salvo com sucesso";
    }

    @Override
    public String buscar() {
        iClienteDao.buscar();
        return "Busca realizada com sucesso";
    }

    @Override
    public String excluir() {
        iClienteDao.excluir();
        return "Cliente excluido com sucesso";
    }

    @Override
    public String atualizar() {
        iClienteDao.atualizar();
        return "Cliente atualizado com sucesso";
    }
}
