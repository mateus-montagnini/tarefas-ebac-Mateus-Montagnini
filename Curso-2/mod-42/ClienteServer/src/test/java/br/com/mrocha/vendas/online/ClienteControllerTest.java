package br.com.mrocha.vendas.online;

import br.com.mrocha.vendas.online.controller.ClienteController;
import br.com.mrocha.vendas.online.domain.Cliente;
import br.com.mrocha.vendas.online.service.BuscaCliente;
import br.com.mrocha.vendas.online.service.CadastroCliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
public class ClienteControllerTest {

    @InjectMocks
    private ClienteController controller;

    @MockBean
    private BuscaCliente buscaCliente;

    @MockBean
    private CadastroCliente cadastroCliente;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getByIdTest() {
        Cliente cliente = Cliente.builder().id(1L).nome("Carlos").build();

        ResponseEntity<Cliente> result = controller.getById("1");

        Cliente clienteResult = result.getBody();
        assertThat(clienteResult).isEqualTo(cliente);
        assertThat(clienteResult.getId()).isEqualTo(cliente.getId());
        assertThat(clienteResult.getNome()).isEqualTo(cliente.getNome());
    }
}
