package br.com.mrocha;

import java.math.BigDecimal;

import br.com.mrocha.dao.IProdutoDAO;
import br.com.mrocha.domain.Produto;
import br.com.mrocha.exceptions.DAOException;
import br.com.mrocha.exceptions.TipoChaveNaoEncontradaException;
import br.com.mrocha.services.IProdutoService;
import br.com.mrocha.services.ProdutoService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import br.com.mrocha.dao.ProdutoDaoMock;

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