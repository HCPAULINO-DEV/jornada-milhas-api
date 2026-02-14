package com.projects.my.jornada_milhas_api.repository;

import com.projects.my.jornada_milhas_api.entity.Depoimento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepoimentoRepository extends JpaRepository<Depoimento, Long> {
    @Query(value = "SELECT * FROM depoimento ORDER BY RANDOM()",  nativeQuery = true)
    Page<Depoimento> findThreeRandom(Pageable pageable);
}
