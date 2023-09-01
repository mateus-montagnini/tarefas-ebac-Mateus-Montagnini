package main.services;

import main.Cliente;

public interface IClienteService {

    Boolean salvar(Cliente cliente);
    Cliente buscarPorCpf(Long cpf);

    void excluir(Long cpf);
    void alterar(Cliente cliente);
}
