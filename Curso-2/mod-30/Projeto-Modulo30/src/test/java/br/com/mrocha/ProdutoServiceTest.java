package test.java.br.com.mrocha;

import java.math.BigDecimal;

import main.java.br.com.mrocha.dao.IProdutoDAO;
import main.java.br.com.mrocha.domain.Produto;
import main.java.br.com.mrocha.exceptions.DAOException;
import main.java.br.com.mrocha.exceptions.TipoChaveNaoEncontradaException;
import main.java.br.com.mrocha.services.IProdutoService;
import main.java.br.com.mrocha.services.ProdutoService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import test.java.br.com.mrocha.dao.ProdutoDaoMock;

public class ProdutoServiceTest {

	private IProdutoService produtoService;
	
	private Produto produto;
	
	public ProdutoServiceTest() {
		IProdutoDAO dao = new ProdutoDaoMock();
		produtoService = new ProdutoService(dao);
	}
	
	@Before
	public void init() {
		produto = new Produto();
		produto.setCodigo("A1");
		produto.setDescricao("Camiseta Polo");
		produto.setNome("Camiseta");
		produto.setValor(BigDecimal.TEN);
	}
	
	@Test
	public void pesquisar() throws DAOException {
		Produto produtor = this.produtoService.consultar(produto.getCodigo());
		Assert.assertNotNull(produtor);
	}
	
	@Test
	public void salvar() throws TipoChaveNaoEncontradaException, DAOException {
		Boolean retorno = produtoService.cadastrar(produto);
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluir() throws DAOException {
		produtoService.excluir(produto.getCodigo());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		produto.setNome("Mateus");
		produtoService.alterar(produto);
		
		Assert.assertEquals("Mateus", produto.getNome());
	}
}
