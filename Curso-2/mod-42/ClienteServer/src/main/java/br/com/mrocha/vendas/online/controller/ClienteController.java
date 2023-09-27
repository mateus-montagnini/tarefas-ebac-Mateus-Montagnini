package br.com.mrocha.vendas.online.controller;

import br.com.mrocha.vendas.online.domain.Cliente;
import br.com.mrocha.vendas.online.service.BuscaCliente;
import br.com.mrocha.vendas.online.service.CadastroCliente;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    private BuscaCliente buscaCliente;
    private CadastroCliente cadastroCliente;

    @Autowired
    public ClienteController(BuscaCliente buscaCliente,
                           CadastroCliente cadastroCliente) {
        this.buscaCliente = buscaCliente;
        this.cadastroCliente = cadastroCliente;
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody @Valid Cliente cliente) {
        return ResponseEntity.ok(cadastroCliente.create(cliente));
    }

    @GetMapping
    public ResponseEntity<Page<Cliente>> getAll(Pageable pageable) {
        return ResponseEntity.ok(buscaCliente.getAll(pageable));
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Busca um cliente pelo id")
    public ResponseEntity<Cliente> getById(@PathVariable(value = "id", required = true) String id) {
        return ResponseEntity.ok(buscaCliente.getByID(id));
    }

    @GetMapping(value = "isCadastrado/{id}")
    public ResponseEntity<Boolean> isCadastrado(@PathVariable(value = "id", required = true) String id) {
        return ResponseEntity.ok(buscaCliente.isCadastrado(id));
    }

    @GetMapping(value = "/cpf/{cpf}")
    @Operation(summary = "Busca um cliente pelo cpf")
    public ResponseEntity<Cliente> getByCpf(@PathVariable(value = "cpf", required = true) Long cpf) {
        return ResponseEntity.ok(buscaCliente.getByCpf(cpf));
    }

    @PutMapping
    @Operation(summary = "Atualiza um cliente")
    public ResponseEntity<Cliente> update(@RequestBody @Valid Cliente cliente) {
        return ResponseEntity.ok(cadastroCliente.update(cliente));
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Deleta um cliente pelo seu id")
    public ResponseEntity<String> delete(@PathVariable(value = "id") String id) {
        cadastroCliente.delete(id);
        return ResponseEntity.ok("Deletado com sucesso");
    }
}
