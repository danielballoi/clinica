package com.api.clinica.repositories;

import com.api.clinica.entities.Animale;
import com.api.clinica.entities.Visita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitaRepo extends JpaRepository<Visita, Long> {
    List<Visita> findByAnimaleOrderByDataAsc(Animale animale);
}
