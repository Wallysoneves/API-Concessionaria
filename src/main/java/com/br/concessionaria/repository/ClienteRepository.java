package com.br.concessionaria.repository;

import com.br.concessionaria.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
