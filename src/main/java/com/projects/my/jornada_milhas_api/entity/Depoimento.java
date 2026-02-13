package com.projects.my.jornada_milhas_api.entity;

import com.projects.my.jornada_milhas_api.dto.SalvarDepoimentoDto;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "depoimento")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Depoimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String foto;
    private String depoimento;
    private String nomePessoa;

}
