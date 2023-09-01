package main.dao;

import main.Cliente;

public interface IClienteDAO {
    Boolean salvar(Cliente cliente);

    Cliente buscarPorCpf(Long cpf);
    void excluir(Long cpf);
    void alterar(Cliente cliente);
}
