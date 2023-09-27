package br.com.mrocha.vendas.online.service;

import br.com.mrocha.vendas.online.domain.Cliente;
import br.com.mrocha.vendas.online.repository.IClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroCliente {

    private IClienteRepository clienteRepository;

    @Autowired
    public CadastroCliente(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente create(@Valid Cliente cliente) {
        return this.clienteRepository.insert(cliente);
    }

    public Cliente update(@Valid Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }

    public void delete(String id) {
        this.clienteRepository.deleteById(id);
    }
}
