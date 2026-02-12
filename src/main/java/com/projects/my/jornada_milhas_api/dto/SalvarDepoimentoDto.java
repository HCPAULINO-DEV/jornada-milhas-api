package com.projects.my.jornada_milhas_api.dto;

import jakarta.validation.constraints.NotBlank;

public record SalvarDepoimentoDto(
        @NotBlank
        String foto,

        @NotBlank
        String depoimento,

        @NotBlank
        String nomePessoa
) {
}
