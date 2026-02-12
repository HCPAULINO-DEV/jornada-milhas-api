package com.projects.my.jornada_milhas_api.dto;

import com.projects.my.jornada_milhas_api.entity.Depoimento;

public record ExibirDadosDepoimentoDto(
        String id,
        String foto,
        String depoimento,
        String nomePessoa
) {
    public ExibirDadosDepoimentoDto(Depoimento depoimento){
        this(depoimento.getId().toString(), depoimento.getFoto(), depoimento.getDepoimento(), depoimento.getNomePessoa());
    }
}
