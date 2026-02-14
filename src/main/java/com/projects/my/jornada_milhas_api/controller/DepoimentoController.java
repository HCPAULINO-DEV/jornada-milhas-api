package com.projects.my.jornada_milhas_api.controller;

import com.projects.my.jornada_milhas_api.dto.ExibirDadosDepoimentoDto;
import com.projects.my.jornada_milhas_api.dto.SalvarDepoimentoDto;
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
public class DepoimentoController {

    @Autowired
    private DepoimentoService depoimentoService;

    @PostMapping("/depoimentos")
    public ResponseEntity<ExibirDadosDepoimentoDto> save(@RequestBody @Valid SalvarDepoimentoDto dto, UriComponentsBuilder uriBuilder) {
        ExibirDadosDepoimentoDto depoimento = depoimentoService.saveDepoimento(dto);
        var uri = uriBuilder.path("/depoimentos/{id}").buildAndExpand(depoimento.id()).toUri();
        return ResponseEntity.created(uri).body(depoimento);
    }

    @GetMapping("/depoimentos")
    public ResponseEntity<Page<ExibirDadosDepoimentoDto>> findAll(@PageableDefault(sort = "id", size = 9) Pageable pageable) {
        return ResponseEntity.ok(depoimentoService.findAll(pageable));
    }

    @GetMapping("/depoimentos/{id}")
    public ResponseEntity<ExibirDadosDepoimentoDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(depoimentoService.findDepoimento(id));
    }

    @PutMapping("/depoimentos/{id}")
    public ResponseEntity<ExibirDadosDepoimentoDto> update(@PathVariable Long id, @RequestBody @Valid SalvarDepoimentoDto dto) {
        return ResponseEntity.ok(depoimentoService.updateDepoimento(id, dto));
    }

    @DeleteMapping("/depoimentos/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        depoimentoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/depoimentos-home")
    public ResponseEntity<Page<ExibirDadosDepoimentoDto>> findThreeDepoimento(@PageableDefault(size = 3) Pageable pageable) {
        return ResponseEntity.ok(depoimentoService.findThreeRandomDepoimento(pageable));
    }

}
