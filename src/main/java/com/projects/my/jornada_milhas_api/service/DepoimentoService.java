package com.projects.my.jornada_milhas_api.service;

import com.projects.my.jornada_milhas_api.dto.ExibirDadosDepoimentoDto;
import com.projects.my.jornada_milhas_api.dto.SalvarDepoimentoDto;
import com.projects.my.jornada_milhas_api.entity.Depoimento;
import com.projects.my.jornada_milhas_api.repository.DepoimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DepoimentoService {

    @Autowired
    private DepoimentoRepository depoimentoRepository;

    public Page<ExibirDadosDepoimentoDto> findAll(Pageable pageable) {
        return depoimentoRepository
                .findAll(pageable)
                .map(ExibirDadosDepoimentoDto::new);
    }

    public ExibirDadosDepoimentoDto save(SalvarDepoimentoDto dto) {
        Depoimento depoimento = new Depoimento(dto);
        depoimentoRepository.save(depoimento);

        return new ExibirDadosDepoimentoDto(depoimento);
    }

    public ExibirDadosDepoimentoDto findDepoimento(Long id) {
        return new ExibirDadosDepoimentoDto(findDepoimentoById(id));
    }

    private Depoimento findDepoimentoById(Long id) {
        return depoimentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Depoimento não encontrado"));
    }
}
