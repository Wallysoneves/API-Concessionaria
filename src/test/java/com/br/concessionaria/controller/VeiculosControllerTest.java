package com.br.concessionaria.controller;

import com.br.concessionaria.model.Veiculo;
import com.br.concessionaria.service.VeiculosService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class VeiculosControllerTest {

    @Mock
    private VeiculosService veiculosService;

    @InjectMocks
    private VeiculosController veiculosController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testBuscarTodosVeiculos() {
        // Arrange
        List<Veiculo> veiculos = List.of(
                Veiculo.builder()
                        .modelo("Fiesta")
                        .ano(2015)
                        .cor("Prata")
                        .placa("ABC123")
                        .marca("Ford")
                        .id(1).build()
        );

        Page<Veiculo> pageVeiculos = new PageImpl<>(veiculos);

        when(veiculosService.buscarTodosVeiculos(0, 1)).thenReturn(pageVeiculos);

        // Act
        ResponseEntity<?> responseEntity = veiculosController.buscarTodosVeiculos(0, 1);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(pageVeiculos, responseEntity.getBody());
        verify(veiculosService, times(1)).buscarTodosVeiculos(0, 1);
    }

    @Test
    public void testBuscarTodosVeiculosInvalido() {
        // Arrange
        String mensagemErro = "O tamanho da página deve ser maior que zero";
        when(veiculosService.buscarTodosVeiculos(0, 0))
                .thenThrow(new IllegalArgumentException(mensagemErro));

        // Act
        ResponseEntity<?> responseEntity = veiculosController.buscarTodosVeiculos(0, 0);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals(mensagemErro, responseEntity.getBody());
        verify(veiculosService, times(1)).buscarTodosVeiculos(0, 0);
    }

    @Test
    public void testBuscarVeiculo() {

        Optional<Veiculo> veiculo = Optional.of(
                Veiculo.builder()
                        .modelo("Fiesta")
                        .ano(2015)
                        .cor("Prata")
                        .placa("ABC123")
                        .marca("Ford")
                        .id(1).build()
        );

        when(veiculosService.buscarVeiculo(1)).thenReturn(veiculo);

        ResponseEntity<Veiculo> responseEntity = veiculosController.buscarVeiculo(1);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(veiculo.get(), responseEntity.getBody());
        verify(veiculosService, times(1)).buscarVeiculo(1);
    }

    @Test
    public void testBuscarVeiculoInvalido() {

        Integer idVeiculo = 0;
        when(veiculosService.buscarVeiculo(idVeiculo)).thenReturn(Optional.empty());

        ResponseEntity<Veiculo> responseEntity = veiculosController.buscarVeiculo(idVeiculo);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        verify(veiculosService, times(1)).buscarVeiculo(idVeiculo);
    }

    @Test
    public void testCadastrarVeiculo() {

        Veiculo veiculo = Veiculo.builder()
                .modelo("Fiesta")
                .ano(2015)
                .cor("Prata")
                .placa("ABC123")
                .marca("Ford")
                .build();

        when(veiculosService.cadastrarVeiculo(veiculo)).thenReturn(veiculo);

        ResponseEntity<Veiculo> responseEntity = veiculosController.cadastrarVeiculo(veiculo);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(veiculo, responseEntity.getBody());
        verify(veiculosService, times(1)).cadastrarVeiculo(veiculo);
    }

    @Test
    public void testAlterarVeiculo() {

        Veiculo veiculo = Veiculo.builder()
                .modelo("Fiesta")
                .ano(2015)
                .cor("Prata")
                .placa("ABC123")
                .marca("Ford")
                .build();

        when(veiculosService.alterarVeiculo(veiculo)).thenReturn(veiculo);

        ResponseEntity<?> responseEntity = veiculosController.alterarVeiculo(veiculo);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(veiculo, responseEntity.getBody());
        verify(veiculosService, times(1)).alterarVeiculo(veiculo);
    }

    @Test
    public void testAlterarVeiculoInvalido() {

        Veiculo veiculo = Veiculo.builder()
                .modelo("Fiesta")
                .ano(2015)
                .cor("Prata")
                .placa("ABC123")
                .marca("Ford")
                .id(0)
                .build();

        String mensagemErro = "O veiculo não foi encontrado!";

        when(veiculosService.alterarVeiculo(veiculo))
                .thenThrow(new IllegalArgumentException(mensagemErro));

        ResponseEntity<?> responseEntity = veiculosController.alterarVeiculo(veiculo);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals(mensagemErro, responseEntity.getBody());
        verify(veiculosService, times(1)).alterarVeiculo(veiculo);
    }

    @Test
    public void testDeletarVeiculo() {
        Integer idVeiculo = 1;

        ResponseEntity<?> responseEntity = veiculosController.deletarVeiculo(idVeiculo);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(veiculosService, times(1)).deletarVeculo(idVeiculo);
    }

    @Test
    public void testDeletarVeiculoInvalido() {
        Integer idVeiculo = 0;
        String mensagemErro = "O veiculo não foi encontrado!";

        //motivo pelo service ser void!
        doThrow(new IllegalArgumentException(mensagemErro)).when(veiculosService).deletarVeculo(idVeiculo);

        ResponseEntity<?> responseEntity = veiculosController.deletarVeiculo(idVeiculo);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals(mensagemErro, responseEntity.getBody());
        verify(veiculosService, times(1)).deletarVeculo(idVeiculo);
    }
}
