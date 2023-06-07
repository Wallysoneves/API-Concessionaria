package com.br.concessionaria.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "veiculos")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "marca", nullable = false, length = 100)
    private String marca;

    @Column(name = "modelo", nullable = false, length = 50)
    private String modelo;

    @Column(name = "ano",nullable = false)
    private Integer ano;

    @Column(name = "placa", nullable = false, length = 10)
    private String placa;

    @Column(name = "cor", nullable = false, length = 50)
    private String cor;


}
