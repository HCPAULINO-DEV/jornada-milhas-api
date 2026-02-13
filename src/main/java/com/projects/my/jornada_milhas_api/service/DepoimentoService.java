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

@Service
public class DepoimentoService {

    @Autowired
    private DepoimentoRepository depoimentoRepository;

    private Depoimento findDepoimentoById(Long id) {
        return depoimentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Depoimento não encontrado"));
    }

    public Page<ExibirDadosDepoimentoDto> findAll(Pageable pageable) {
        return depoimentoRepository
                .findAll(pageable)
                .map(ExibirDadosDepoimentoDto::new);
    }

    public ExibirDadosDepoimentoDto saveDepoimento(SalvarDepoimentoDto dto) {
        Depoimento depoimento = new Depoimento();
        depoimento.setFoto(dto.foto());
        depoimento.setDepoimento(dto.depoimento());
        depoimento.setNomePessoa(dto.nomePessoa());
        depoimentoRepository.save(depoimento);
        return new ExibirDadosDepoimentoDto(depoimento);
    }

    public ExibirDadosDepoimentoDto findDepoimento(Long id) {
        return new ExibirDadosDepoimentoDto(findDepoimentoById(id));
    }

    public ExibirDadosDepoimentoDto updateDepoimento(Long id, @Valid SalvarDepoimentoDto dto) {
        Depoimento depoimento = findDepoimentoById(id);
        depoimento.setFoto(dto.foto());
        depoimento.setDepoimento(dto.depoimento());
        depoimento.setNomePessoa(dto.nomePessoa());
        return new ExibirDadosDepoimentoDto(depoimento);
    }

    public void delete(Long id) {
        depoimentoRepository.delete(findDepoimentoById(id));
    }
}
