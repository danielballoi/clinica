package com.api.clinica.services;

import com.api.clinica.entities.Animale;
import com.api.clinica.entities.Visita;
import com.api.clinica.repositories.VisitaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VisitaService {
    List<Visita> findByIdAnimale(Animale animale);
    Visita save(Visita visita);
    void deleteById(Long id);


}
