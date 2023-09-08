import br.com.mrocha.dao.IProdutoDAO;
import br.com.mrocha.dao.ProdutoDAO;
import br.com.mrocha.domain.Produto;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ProdutoTeste {
    private IProdutoDAO produtoDAO;

    public ProdutoTeste() {
        produtoDAO = new ProdutoDAO();
    }

    @Test
    public void cadastrar() {
        Produto produto = new Produto();
        produto.setNome("Produto 6");
        produto.setDescricao("Descricao do produto 6");
        produto.setPreco(10.50);
        produto = produtoDAO.cadastrar(produto);

        assertNotNull(produto);
        assertNotNull(produto.getId());
    }
}