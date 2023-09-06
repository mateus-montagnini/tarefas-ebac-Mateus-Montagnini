import dao.generic.jdbc.dao.ClienteDAO;
import dao.generic.jdbc.dao.IProdutoDAO;
import dao.generic.jdbc.dao.ProdutoDAO;
import domain.Cliente;
import domain.Produto;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ProdutoTeste {

    private IProdutoDAO produtoDAO;

    @Test
    public void cadastrarTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("15");
        produto.setNome("Camiseta");
        produto.setPreco(10.50);
        Integer count = produtoDAO.cadastrar(produto);
        assertEquals(1, (int) count);
    }

    @Test
    public void consultarTeste() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("15");
        produto.setNome("Camiseta");
        produto.setPreco(10.50);
        Integer count = produtoDAO.cadastrar(produto);
        assertTrue(count == 1);

        Produto produtoDB = produtoDAO.consultar("15");
        assertNotNull(produtoDB);
        assertEquals(produto.getCodigo(), produtoDB.getCodigo());
        assertEquals(produto.getNome(), produto.getNome());
        assertEquals(produto.getPreco(), produtoDB.getPreco(), produtoDB.getPreco());
    }

    @Test
    public void excluirTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("15");
        produto.setNome("Camiseta");
        produto.setPreco(10.50);
        Integer count = produtoDAO.cadastrar(produto);
        assertTrue(count == 1);

        Produto produtoDB = produtoDAO.consultar("15");
        assertNotNull(produtoDB);
        assertEquals(produto.getCodigo(), produtoDB.getCodigo());
        assertEquals(produto.getNome(), produtoDB.getNome());
        assertEquals(produto.getPreco(), produtoDB.getPreco(), produtoDB.getPreco());

        Integer countDB = produtoDAO.excluir(produtoDB);
        assertTrue(countDB == 0);
    }

    @Test
    public void buscarTodosTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("15");
        produto.setNome("Camiseta");
        produto.setPreco(10.50);
        Integer count = produtoDAO.cadastrar(produto);
        assertTrue(count == 1);

        Produto produtoDB = new Produto();
        produtoDB.setCodigo("08");
        produtoDB.setNome("Teste");
        produtoDB.setPreco(19.50);
        Integer countDB = produtoDAO.cadastrar(produtoDB);
        assertTrue(countDB == 1);

        List<Produto> list = produtoDAO.buscarTodos();
        assertNotNull(list);

        int countFinal = 0;
        for (Produto cli : list) {
            produtoDAO.excluir(cli);
            countFinal++;
        }
        assertEquals(list.size(), countFinal);

        list = produtoDAO.buscarTodos();
        assertEquals(list.size(), 0);

    }
}
