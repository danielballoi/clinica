package com.api.clinica.services.serviceImpl;

import com.api.clinica.entities.Animale;
import com.api.clinica.entities.Visita;
import com.api.clinica.repositories.VisitaRepo;
import com.api.clinica.services.VisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VisitaServImpl implements VisitaService {
    @Autowired
    private VisitaRepo visitaRepo;

    @Override
    public List<Visita> findByIdAnimale(Animale animale) {
        return visitaRepo.findByAnimaleOrderByDataAsc(animale);
    }

    @Override
    public Visita save(Visita visita) {
        return visitaRepo.save(visita);
    }

    @Override
    public void deleteById(Long id) {
        visitaRepo.deleteById(id);
    }
}
