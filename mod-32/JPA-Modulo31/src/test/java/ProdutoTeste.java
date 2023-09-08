import br.com.mrocha.dao.IProdutoDAO;
import br.com.mrocha.dao.ProdutoDAO;
import br.com.mrocha.domain.Produto;
import org.junit.After;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ProdutoTeste {
    private IProdutoDAO produtoDAO;

    private Produto criarProduto() {
        Produto produto = new Produto();
        produto.setNome("Produto 1");
        produto.setDescricao("Descricao do produto 1");
        produto.setPreco(15.50);
        produto = produtoDAO.cadastrar(produto);
        return produto;
    }

    public ProdutoTeste() {
        produtoDAO = new ProdutoDAO();
    }

    @After
    public void end() {
        List<Produto> lista = produtoDAO.buscarTodos();
        lista.forEach(l -> produtoDAO.excluir(l));
    }

    @Test
    public void cadastrarTest() {
        Produto produto = criarProduto();
        assertNotNull(produto);

        Produto produtoDB = produtoDAO.consultarId(produto.getId());
        assertNotNull(produtoDB);
        assertEquals(produto.getId(), produtoDB.getId());
        assertEquals(produto.getNome(), produtoDB.getNome());

    }

//    @Test
//    public void atualizarTeste() {
//        Produto produto = criarProduto();
//        assertNotNull(produto);
//
//        Produto produtoDB = produtoDAO.consultarId(produto.getId());
//        produtoDB.setNome("Produto Atualizado");
//        Produto produtoAtualizado = produtoDAO.atualizar(produtoDB);
//        assertEquals("Produto Atualizado", produtoAtualizado.getNome());
//    }

//    @Test
//    public void consultarTeste(Long id) {
//
//    }

    // Consultar, Excluir, Atualizar
}
