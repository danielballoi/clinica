package com.api.clinica.facades;

import com.api.clinica.entities.Animale;
import com.api.clinica.entities.Visita;
import com.api.clinica.entities.pojo.AnimalePojo;
import com.api.clinica.services.AnimaleService;
import com.api.clinica.services.VisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VisitaFacade {
    @Autowired
    private VisitaService visitaService;
    @Autowired
    private AnimaleService animaleService;
    public List<Visita> findByIdAnimale(String id){
        Animale animale = animaleService.findById(Long.valueOf(id));
        return visitaService.findByIdAnimale(animale);
    }
    public Animale findById(String id){
        return animaleService.findById(Long.valueOf(id));
    }
    public Visita save(Visita data){
        Visita visita = new Visita(null, data.getTipologia(), data.getData(), data.getAnimale());
        visitaService.save(visita);
        return visita;
    }
    public Animale edit(AnimalePojo data, String id){
        Animale animale= new Animale(Long.valueOf(id),data.getNome(), data.getNomePadrone());
        animaleService.save(animale);
        return animale;
    }
    public void delete(String id){
        visitaService.deleteById(Long.valueOf(id));
    }
}
