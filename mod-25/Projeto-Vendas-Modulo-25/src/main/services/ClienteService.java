package main.services;

import main.Cliente;
import main.dao.IClienteDAO;

public class ClienteService implements IClienteService {

    private IClienteDAO iClienteDAO;

    public ClienteService(IClienteDAO iClienteDAO) {
        this.iClienteDAO = iClienteDAO;
    }

    @Override
    public Boolean salvar(Cliente cliente) {
        iClienteDAO.salvar(cliente);
        return true;
    }

    @Override
    public Cliente buscarPorCpf(Long cpf) {
        return iClienteDAO.buscarPorCpf(cpf);
    }

    @Override
    public void excluir(Long cpf) {
        iClienteDAO.excluir(cpf);
    }

    @Override
    public void alterar(Cliente cliente) {
        iClienteDAO.alterar(cliente);
    }
}
