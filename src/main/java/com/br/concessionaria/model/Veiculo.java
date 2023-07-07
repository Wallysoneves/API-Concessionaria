package com.br.concessionaria.model;

import com.br.concessionaria.model.enuns.EnumStatusVeiculo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "veiculos")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "A marca do veículo deve ser informada")
    @Column(name = "marca", nullable = false, length = 100)
    private String marca;

    @NotBlank(message = "O modelo do veículo deve ser informada")
    @Column(name = "modelo", nullable = false, length = 50)
    private String modelo;

    @NotNull(message = "O ano do veículo deve ser informada")
    @Column(name = "ano",nullable = false)
    private Integer ano;

    @NotBlank(message = "A placa do veículo deve ser informada")
    @Column(name = "placa", nullable = false, length = 10)
    private String placa;

    @NotBlank(message = "A cor do veículo deve ser informada")
    @Column(name = "cor", nullable = false, length = 50)
    private String cor;

    @NotBlank(message = "O status do veículo deve ser informado")
    @Column(name = "status", nullable = false, length = 1)
    private EnumStatusVeiculo status;


}
