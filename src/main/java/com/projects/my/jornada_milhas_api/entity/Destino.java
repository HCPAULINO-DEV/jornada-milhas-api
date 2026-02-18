package com.projects.my.jornada_milhas_api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "depoimento")
public class Destino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String foto;
    private String nome;
    private Double preco;
}
