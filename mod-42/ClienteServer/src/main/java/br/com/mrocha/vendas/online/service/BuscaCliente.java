package br.com.mrocha.vendas.online.service;

import br.com.mrocha.vendas.online.domain.Cliente;
import br.com.mrocha.vendas.online.exception.NotFoundException;
import br.com.mrocha.vendas.online.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuscaCliente {

    private IClienteRepository clienteRepository;

    @Autowired
    public BuscaCliente(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Page<Cliente> get(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }

    public Cliente getByID(String id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Cliente.class, "id", id));
    }

    public Boolean isCadastrado(String id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.isPresent() ? true : false;
    }

    public Cliente getByCpf(Long cpf) {
        return clienteRepository.findByCpf(cpf)
                .orElseThrow(() -> new NotFoundException(Cliente.class, "cpf", String.valueOf(cpf)));
    }
}
