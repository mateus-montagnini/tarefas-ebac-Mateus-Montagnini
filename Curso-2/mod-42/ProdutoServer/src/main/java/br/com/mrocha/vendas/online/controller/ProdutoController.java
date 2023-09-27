package br.com.mrocha.vendas.online.controller;

import br.com.mrocha.vendas.online.domain.Produto;
import br.com.mrocha.vendas.online.service.BuscaProduto;
import br.com.mrocha.vendas.online.service.CadastroProduto;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {

    private BuscaProduto buscaProduto;

    private CadastroProduto cadastroProduto;

    @Autowired
    public ProdutoController(BuscaProduto buscaProduto,
                           CadastroProduto cadastroProduto) {
        this.buscaProduto = buscaProduto;
        this.cadastroProduto = cadastroProduto;
    }

    @GetMapping
    @Operation(summary = "Busca uma lista paginada de produtos")
    public ResponseEntity<Page<Produto>> getAll(Pageable pageable) {
        return ResponseEntity.ok(buscaProduto.getAll(pageable));
    }

    @GetMapping(value = "/status/{status}")
    @Operation(summary = "Busca uma lista paginada de produtos por status")
    public ResponseEntity<Page<Produto>> getByStatus(Pageable pageable,
                                                         @PathVariable(value = "status", required = true) Produto.Status status) {
        return ResponseEntity.ok(buscaProduto.getAll(pageable, status));
    }

    @GetMapping(value = "/{codigo}")
    @Operation(summary = "Busca um produto pelo codigo")
    public ResponseEntity<Produto> getByCodigo(String codigo) {
        return ResponseEntity.ok(buscaProduto.getByCodigo(codigo));
    }

    @PostMapping
    @Operation(summary = "Cria um produto")
    public ResponseEntity<Produto> create(@RequestBody @Valid Produto produto) {
        return ResponseEntity.ok(cadastroProduto.create(produto));
    }

    @PutMapping
    @Operation(summary = "Atualiza um produto")
    public ResponseEntity<Produto> update(@RequestBody @Valid Produto produto) {
        return ResponseEntity.ok(cadastroProduto.update(produto));
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Deleta um produto pelo seu id")
    public ResponseEntity<String> delete(@PathVariable(value = "id") String id) {
        cadastroProduto.delete(id);
        return ResponseEntity.ok("Deletado com sucesso");
    }
}
