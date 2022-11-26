package com.api.clinica.facades;

import com.api.clinica.entities.Animale;
import com.api.clinica.entities.pojo.AnimalePojo;
import com.api.clinica.services.AnimaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnimaleFacade {
    @Autowired
    private AnimaleService animaleService;

    public List<Animale> findAll(){
        return animaleService.findAll();
    }
    public Animale findById(String id){
        return animaleService.findById(Long.valueOf(id));
    }
    public Animale save(AnimalePojo data){
        Animale animale= new Animale(null,data.getNome(), data.getNomePadrone());
        animaleService.save(animale);
        return animale;
    }
    public Animale edit(AnimalePojo data, String id){
        Animale animale= new Animale(Long.valueOf(id),data.getNome(), data.getNomePadrone());
        animaleService.save(animale);
        return animale;
    }
    public void delete(String id){
        animaleService.deleteById(Long.valueOf(id));
    }
}
