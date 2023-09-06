import dao.generic.jdbc.dao.ClienteDAO;
import dao.generic.jdbc.dao.IProdutoDAO;
import dao.generic.jdbc.dao.ProdutoDAO;
import domain.Cliente;
import domain.Produto;
import org.junit.Test;

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
        Integer countCad = produtoDAO.cadastrar(produto);
        assertEquals(1, (int) countCad);

        Produto produtoDB = produtoDAO.consultar("15");
        assertNotNull(produtoDB);
        assertEquals(produto.getCodigo(), produtoDB.getCodigo());
        assertEquals(produto.getNome(), produtoDB.getNome());
        assertEquals(produto.getPreco(), produtoDB.getPreco(), produtoDB.getPreco());

//        Integer countDel = produtoDAO.excluir(produtoDB);
//        assertEquals(1, (int) countDel);
    }
}
