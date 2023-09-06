package dao.generic.jdbc.dao;

import domain.Cliente;

import java.util.List;

public interface IClienteDAO {
    Integer cadastrar(Cliente cliente) throws Exception;
    Integer atualizar(Cliente cliente) throws Exception;
    Cliente consultar(String codigo) throws Exception;
    Integer excluir(Cliente clienteBD) throws Exception;
    List<Cliente> buscarTodos() throws Exception;

}
