package br.com.mrocha.vendas.online.service;

import br.com.mrocha.vendas.online.domain.Produto;
import br.com.mrocha.vendas.online.exception.NotFoundException;
import br.com.mrocha.vendas.online.repository.IProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BuscaProduto {

    private IProdutoRepository produtoRepository;

    @Autowired
    public BuscaProduto(IProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Page<Produto> getAll(Pageable pageable) {
        return produtoRepository.findAll(pageable);
    }

    public Page<Produto> getAll(Pageable pageable, Produto.Status status) {
        return produtoRepository.findAllByStatus(pageable, status);
    }

    public Produto getByCodigo(String codigo) {
        return produtoRepository.findByCodigo(codigo)
                .orElseThrow(() -> new NotFoundException(Produto.class, "codigo", codigo));
    }
}
