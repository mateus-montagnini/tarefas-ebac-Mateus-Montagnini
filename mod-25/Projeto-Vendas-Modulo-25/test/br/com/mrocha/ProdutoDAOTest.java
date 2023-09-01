package br.com.mrocha;

import main.dao.IProdutoDAO;
import main.dao.ProdutoDAO;
import main.domain.Produto;
import main.exception.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collection;

public class ProdutoDAOTest {

    private IProdutoDAO produtoDao;

    private Produto produto;

    public ProdutoDAOTest() {
        produtoDao = new ProdutoDAO();
    }

    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        produto = new Produto();
        produto.setCodigo("C023");
        produto.setDescricao("Camisa");
        produto.setNome("Camisa");
        produto.setValor(BigDecimal.TEN);
        produtoDao.cadastrar(produto);
    }

    @Test
    public void pesquisar() {
        Produto produto = this.produtoDao.consultar(this.produto.getCodigo());
        Assert.assertNotNull(produto);
    }

    @Test
    public void salvar() throws TipoChaveNaoEncontradaException {
        produto.setCodigo("A2");
        Boolean retorno = produtoDao.cadastrar(produto);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluir() {
        produtoDao.excluir(produto.getCodigo());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        produto.setNome("Rodrigo Pires");
        produtoDao.alterar(produto);

        Assert.assertEquals("Rodrigo Pires", produto.getNome());
    }

//    @Test
//    public void buscarTodos() {
//        Collection<Produto> list = produtoDao.buscarTodos();
//        assertTrue(list != null);
//        assertTrue(list.size() == 2);
//    }
}
