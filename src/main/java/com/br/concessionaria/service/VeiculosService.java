package com.br.concessionaria.service;

import com.br.concessionaria.model.Veiculo;
import com.br.concessionaria.repository.VeiculosRepos;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class VeiculosService {

    @Autowired
    private VeiculosRepos veiculosRepos;

    public Page<Veiculo> buscarTodosVeiculos(Integer pagina, Integer tamanho) {

        if (pagina < 0) throw new IllegalArgumentException("O numero da página deve ser maior ou igual a zero!");
        if (tamanho <= 0) throw new IllegalArgumentException("O tamanho da página deve ser maior que zero");

        Pageable pg = PageRequest.of(pagina, tamanho);
        return veiculosRepos.findAll(pg);
    }

    public Optional<Veiculo> buscarVeiculo(Integer idVeiculo) {
        return veiculosRepos.findById(idVeiculo);
    }

    public Veiculo cadastrarVeiculo(Veiculo veiculo) {
        return veiculosRepos.save(veiculo);
    }

    public Veiculo alterarVeiculo(@NotNull Veiculo veiculo) {
        if (! veiculosRepos.existsById(veiculo.getId()) ) {
            throw new IllegalArgumentException("O veiculo não foi encontrado!");
        }

        return veiculosRepos.save(veiculo);
    }

    public void deletarVeculo(Integer idVeiculo) {
        if (! veiculosRepos.existsById(idVeiculo) ) {
            throw new IllegalArgumentException("O veiculo não foi encontrado!");
        }

        veiculosRepos.deleteById(idVeiculo);
    }
}
