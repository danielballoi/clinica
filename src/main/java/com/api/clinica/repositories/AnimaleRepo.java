package com.api.clinica.repositories;

import com.api.clinica.entities.Animale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimaleRepo extends JpaRepository<Animale, Long> {

    List<Animale> findAllByOrderByNomeAsc();
}
