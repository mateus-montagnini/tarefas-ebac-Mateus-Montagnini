package dao.generic.jdbc.dao;

import domain.Cliente;
import domain.Produto;

import java.util.List;

public interface IProdutoDAO {

    Integer cadastrar(Produto cliente) throws Exception;
    Integer atualizar(Produto cliente) throws Exception;
    Produto consultar(String codigo) throws Exception;
    Integer excluir(Produto clienteBD) throws Exception;
    List<Produto> buscarTodos() throws Exception;
}
