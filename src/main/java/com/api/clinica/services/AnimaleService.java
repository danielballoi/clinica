package com.api.clinica.services;

import com.api.clinica.entities.Animale;
import com.api.clinica.repositories.AnimaleRepo;
import com.api.clinica.services.serviceImpl.AnimaleServImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface AnimaleService {
    public List<Animale> findAll();
    public Animale findById(Long id);
    public Animale save(Animale animale);

    public void deleteById(Long id);
}
