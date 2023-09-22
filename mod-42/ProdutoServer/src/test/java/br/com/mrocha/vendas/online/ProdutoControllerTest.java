package br.com.mrocha.vendas.online;

import br.com.mrocha.vendas.online.controller.ProdutoController;
import br.com.mrocha.vendas.online.domain.Produto;
import br.com.mrocha.vendas.online.service.BuscaProduto;
import br.com.mrocha.vendas.online.service.CadastroProduto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class ProdutoControllerTest {

    @InjectMocks
    private ProdutoController controller;

    @MockBean
    private BuscaProduto buscaProduto;

    @MockBean
    private CadastroProduto cadastroProduto;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getByCodigoTest() {
        Produto produto = Produto.builder().id("1").codigo("A15").nome("Produto 1").build();

        ResponseEntity<Produto> result = controller.getByCodigo("A15");

        Produto produtoResult = result.getBody();
        assertThat(produtoResult).isEqualTo(produto);
        assertThat(produtoResult.getId()).isEqualTo(produto.getId());
        assertThat(produtoResult.getCodigo()).isEqualTo(produto.getCodigo());
        assertThat(produtoResult.getNome()).isEqualTo(produto.getNome());
    }
}
