package com.br.concessionaria.service;

import com.br.concessionaria.model.Cliente;
import com.br.concessionaria.repository.ClienteRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    public Cliente cadastrarCliente(@NotNull Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente alterarCliente(@NotNull Cliente cliente) {

        if (! clienteRepository.existsById(cliente.getId())) {
            throw new IllegalArgumentException("Cliente não encontrado!");
        }

        return clienteRepository.save(cliente);
    }

    public void deletarCliente(@NotNull Long clienteId) {

        if (! clienteRepository.existsById(clienteId)) {
            throw new IllegalArgumentException("Cliente não encontrado!");
        }

        clienteRepository.deleteById(clienteId);
    }


}
