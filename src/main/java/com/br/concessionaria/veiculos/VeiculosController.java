package com.br.concessionaria.veiculos;

import com.br.concessionaria.model.Veiculo;
import com.br.concessionaria.service.VeiculosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("veiculos")
public class VeiculosController {

    @Autowired
    private VeiculosService veiculosService;

    @GetMapping(path = "todos")
    public ResponseEntity<?> buscarTodosVeiculos(
                                        @RequestParam(defaultValue = "0") Integer pagina,
                                        @RequestParam(defaultValue = "10") Integer tamanho) {

        try {
            return ResponseEntity.ok(veiculosService.buscarTodosVeiculos(pagina, tamanho));

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(path = "{idVeiculo}")
    public ResponseEntity<Veiculo> buscarVeiculo(@PathVariable("idVeiculo") Integer idVeiculo) {
        Optional<Veiculo> veiculoEncontrado = veiculosService.buscarVeiculo(idVeiculo);
        return veiculoEncontrado.isPresent() ? ResponseEntity.ok(veiculoEncontrado.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Veiculo> cadastrarVeiculo(@RequestBody Veiculo veiculo) {
        return ResponseEntity.ok(veiculosService.cadastrarVeiculo(veiculo));
    }

    @PutMapping
    public ResponseEntity<?> alterarVeiculo(@RequestBody Veiculo veiculo) {

        try {
            return ResponseEntity.ok(veiculosService.alterarVeiculo(veiculo));

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletarVeiculo(@PathVariable("id") Integer idVeiculo) {
        try {
            veiculosService.deletarVeculo(idVeiculo);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
