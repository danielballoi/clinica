package com.api.clinica.services.serviceImpl;

import com.api.clinica.entities.Animale;
import com.api.clinica.repositories.AnimaleRepo;
import com.api.clinica.services.AnimaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class AnimaleServImpl implements AnimaleService {
    @Autowired
    private AnimaleRepo animaleRepo;

    @Override
    public List<Animale> findAll() {
        return animaleRepo.findAllByOrderByNomeAsc();
    }

    @Override
    public Animale findById(Long id) {
        return animaleRepo.findById(id).orElse(null);
    }

    @Override
    public Animale save(Animale animale) {
        return animaleRepo.save(animale);
    }

    @Override
    public void deleteById(Long id) {
        animaleRepo.deleteById(id);
    }
}
