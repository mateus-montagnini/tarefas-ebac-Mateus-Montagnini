package br.com.mrocha.vendas.online.service;

import br.com.mrocha.vendas.online.domain.Produto;
import br.com.mrocha.vendas.online.exception.NotFoundException;
import br.com.mrocha.vendas.online.repository.IProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroProduto {

    private IProdutoRepository produtoRepository;

    @Autowired
    public CadastroProduto(IProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto create(@Valid Produto produto) {
        produto.setStatus(Produto.Status.ATIVO);
        return this.produtoRepository.insert(produto);
    }

    public Produto update(@Valid Produto produto) {
        return this.produtoRepository.save(produto);
    }

    public void delete(String id) {
        Produto prod = produtoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Produto.class, "id", id));
        prod.setStatus(Produto.Status.INATIVO);
        this.produtoRepository.save(prod);
    }
}
