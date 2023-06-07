package com.br.concessionaria.model.service;

import com.br.concessionaria.model.Veiculo;
import com.br.concessionaria.repository.VeiculosRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class VeiculosService {

    @Autowired
    private VeiculosRepos veiculosRepos;

    public Page<Veiculo> buscarTodosVeiculos(Integer pagina, Integer tamanho) {
        Pageable pg = PageRequest.of(pagina, tamanho);
        return veiculosRepos.findAll(pg);
    }
}
