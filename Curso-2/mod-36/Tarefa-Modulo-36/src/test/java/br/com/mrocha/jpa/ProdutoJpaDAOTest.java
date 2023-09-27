package br.com.mrocha.jpa;

import br.com.mrocha.dao.jpa.IProdutoJpaDAO;
import br.com.mrocha.dao.jpa.ProdutoJpaDAO;
import br.com.mrocha.domain.jpa.ProdutoJpa;
import br.com.mrocha.exceptions.DAOException;
import br.com.mrocha.exceptions.MaisDeUmRegistroException;
import br.com.mrocha.exceptions.TableException;
import br.com.mrocha.exceptions.TipoChaveNaoEncontradaException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.math.BigDecimal;
import java.util.Collection;

import static org.junit.Assert.*;

public class ProdutoJpaDAOTest {

    private IProdutoJpaDAO produtoDao;

    public ProdutoJpaDAOTest() {
        this.produtoDao = new ProdutoJpaDAO();
    }

    @BeforeEach
    public void end() throws DAOException {
        Collection<ProdutoJpa> list = produtoDao.buscarTodos();
        list.forEach(cli -> {
            try {
                produtoDao.excluir(cli);
            } catch (DAOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }

    @Test
    public void pesquisar() throws MaisDeUmRegistroException, TableException, DAOException, TipoChaveNaoEncontradaException {
        ProdutoJpa produto = criarProduto("A1");
        assertNotNull(produto);
        ProdutoJpa produtoDB = this.produtoDao.consultar(produto.getId());
        assertNotNull(produtoDB);
    }

    @Test
    public void salvar() throws TipoChaveNaoEncontradaException, DAOException {
        ProdutoJpa produto = criarProduto("A2");
        assertNotNull(produto);
    }

    @Test
    public void excluir() throws DAOException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
        ProdutoJpa produto = criarProduto("A3");
        assertNotNull(produto);
        this.produtoDao.excluir(produto);
        ProdutoJpa produtoBD = this.produtoDao.consultar(produto.getId());
        assertNull(produtoBD);
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
        ProdutoJpa produto = criarProduto("A4");
        produto.setNome("Carlos Henrique");
        produtoDao.alterar(produto);
        ProdutoJpa produtoBD = this.produtoDao.consultar(produto.getId());
        assertNotNull(produtoBD);
        Assert.assertEquals("Carlos Henrique", produtoBD.getNome());
    }

    @Test
    public void buscarTodos() throws DAOException, TipoChaveNaoEncontradaException {
        criarProduto("A5");
        criarProduto("A6");
        Collection<ProdutoJpa> list = produtoDao.buscarTodos();
        assertTrue(list != null);

    }

    private ProdutoJpa criarProduto(String codigo) throws TipoChaveNaoEncontradaException, DAOException {
        ProdutoJpa produto = new ProdutoJpa();
        produto.setCodigo(codigo);
        produto.setDescricao("Cadeira");
        produto.setNome("Mesa");
        produto.setValor(BigDecimal.TEN);
        produtoDao.cadastrar(produto);
        return produto;
    }
}
