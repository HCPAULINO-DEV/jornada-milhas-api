package com.projects.my.jornada_milhas_api.service;

import com.projects.my.jornada_milhas_api.dto.ExibirDadosDepoimentoDto;
import com.projects.my.jornada_milhas_api.dto.SalvarDepoimentoDto;
import com.projects.my.jornada_milhas_api.entity.Depoimento;
import com.projects.my.jornada_milhas_api.repository.DepoimentoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class DepoimentoService {

    @Autowired
    private DepoimentoRepository depoimentoRepository;

    public Page<ExibirDadosDepoimentoDto> findAll(Pageable pageable) {
        return depoimentoRepository
                .findAll(pageable)
                .map(ExibirDadosDepoimentoDto::new);
    }

    public Depoimento save(@RequestBody @Valid SalvarDepoimentoDto dto) {
        Depoimento depoimento = new Depoimento(dto);

        return depoimentoRepository.save(depoimento);
    }
}
