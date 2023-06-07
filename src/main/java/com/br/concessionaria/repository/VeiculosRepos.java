package com.br.concessionaria.repository;

import com.br.concessionaria.model.Veiculo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface VeiculosRepos extends CrudRepository<Veiculo, Integer> {

    Page<Veiculo> findAll(Pageable pageable);

}
