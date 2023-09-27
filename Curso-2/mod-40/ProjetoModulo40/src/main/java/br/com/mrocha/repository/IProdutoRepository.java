package br.com.mrocha.repository;

import br.com.mrocha.domain.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProdutoRepository extends CrudRepository<Produto, Long> {
}
