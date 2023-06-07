package com.br.concessionaria.controller;

import com.br.concessionaria.model.Veiculo;
import com.br.concessionaria.model.service.VeiculosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("veiculos")
public class VeiculosController {

    @Autowired
    private VeiculosService veiculosService;

    @GetMapping
    public ResponseEntity<Page<Veiculo>> buscarTodosVeiculos(
                                        @RequestParam(defaultValue = "0") Integer pagina,
                                        @RequestParam(defaultValue = "10") Integer tamanho) {

        return ResponseEntity.ok(veiculosService.buscarTodosVeiculos(pagina, tamanho));
    }
}
