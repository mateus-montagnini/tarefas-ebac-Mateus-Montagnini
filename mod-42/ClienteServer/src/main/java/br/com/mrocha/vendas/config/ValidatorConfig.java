package br.com.mrocha.vendas.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "br.com.mrocha.vendas.online.repository")
public class ValidatorConfig {
}
