package com.br.concessionaria.model.enuns;

public enum EnumStatusVeiculo {

    DISPONIVEL("Veículo está disponivel para aluguel.", "D"),
    ALUGADO("Veículo está alugado.", "A"),
    ESTRAGADO("Veículo está com algum defeito.", "E");
    

    private final String descricao;
    private final String codigo;


    EnumStatusVeiculo(String descricao, String codigo) {
        this.descricao = descricao;
        this.codigo = codigo;
    }
}
