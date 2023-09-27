package br.com.mrocha.ProjetoModulo40;

import br.com.mrocha.domain.Produto;
import br.com.mrocha.repository.IProdutoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackages = "br.com.mrocha.repository")
@EntityScan("br.com.mrocha.*")
@ComponentScan("br.com.mrocha")
public class ProjetoModulo40Application implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(ProjetoModulo40Application.class);

	@Autowired
	private IProdutoRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoModulo40Application.class, args);
	}

	private Produto createProduto() {
		return Produto.builder()
				.nome("Produto 1")
				.descricao("Descricao do produto 1")
				.preco(50.90)
				.quantidade(15)
				.build();
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Start Application...");
		Produto produto = createProduto();
		repository.save(produto);
	}
}
