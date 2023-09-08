package br.com.mrocha.dao;

import br.com.mrocha.domain.Produto;

import java.util.List;

public interface IProdutoDAO {

    Produto cadastrar(Produto produto);
    Produto consultarId(Long id);
    void excluir(Produto produto);
    Produto atualizar(Produto produto);
    List<Produto> buscarTodos();
}
