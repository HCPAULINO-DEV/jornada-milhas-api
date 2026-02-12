package com.projects.my.jornada_milhas_api.controller;

import com.projects.my.jornada_milhas_api.dto.ExibirDadosDepoimentoDto;
import com.projects.my.jornada_milhas_api.dto.SalvarDepoimentoDto;
import com.projects.my.jornada_milhas_api.entity.Depoimento;
import com.projects.my.jornada_milhas_api.service.DepoimentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/depoimentos")
public class DepoimentoController {

    @Autowired
    private DepoimentoService depoimentoService;

    @PostMapping
    public ResponseEntity<ExibirDadosDepoimentoDto> save(@RequestBody @Valid SalvarDepoimentoDto dto, UriComponentsBuilder uriBuilder) {
        ExibirDadosDepoimentoDto depoimento = depoimentoService.save(dto);
        var uri = uriBuilder.path("/depoimentos/{id}").buildAndExpand(depoimento.id()).toUri();
        return ResponseEntity.created(uri).body(depoimento);
    }

    @GetMapping
    public ResponseEntity<Page<ExibirDadosDepoimentoDto>> findAll(@PageableDefault(sort = "id", size = 9) Pageable pageable) {
        return ResponseEntity.ok(depoimentoService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExibirDadosDepoimentoDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(depoimentoService.findDepoimento(id));
    }

}
