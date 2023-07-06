package com.br.concessionaria.controller;

import com.br.concessionaria.model.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @GetMapping
    public ResponseEntity<List<Cliente>> buscarTodos() {
        return ResponseEntity.ok(null);
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(Cliente cliente) {
        return ResponseEntity.ok(null);
    }

    @PutMapping
    public ResponseEntity<Cliente> alterarCliente(Cliente cliente) {
        return ResponseEntity.ok(null);
    }

    @DeleteMapping
    public ResponseEntity<?> deletarCliente(@RequestParam("clienteId") Long clienteId) {
        return ResponseEntity.ok(null);
    }
}
