package com.api.clinica.controllers;

import com.api.clinica.entities.Animale;
import com.api.clinica.entities.pojo.AnimalePojo;
import com.api.clinica.facades.AnimaleFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;


@Controller
@RequestMapping("/animale")
public class AnimaleController {
    @Autowired
    private AnimaleFacade animaleFacade;

    @GetMapping(value = "/findAll")
    private String findAll(Model model) {
        List<Animale> animaleList = animaleFacade.findAll();
        model.addAttribute("animali", animaleList);
        return "home";
    }

    @GetMapping(value = "/insert")
    private String insPage(Model model) {
        AnimalePojo data = new AnimalePojo();
        model.addAttribute("animale", data);
        return "insert";
    }
    @GetMapping(value = "/edit/{id}")
    private String insPage(Model model, @PathVariable String id) {
        Animale data = animaleFacade.findById(id);
        model.addAttribute("animale", data);
        return "edit";
    }
    @PostMapping(value = "/save/{id}")
    private String save(Model model, @ModelAttribute(value = "animale") AnimalePojo animale, @PathVariable String id) {
        model.addAttribute("animale", animale);
        if (!animale.getNome().matches("^[0-9]*$") && !animale.getNomePadrone().matches("^[0-9]*$")) {
            Animale newAnimal = animaleFacade.edit(animale, id);
            return "redirect:/animale/findAll";
        }else {
            model.addAttribute("animale", new AnimalePojo());
            return "/insert";
        }
    }
    @PostMapping(value = "/save")
    private String save(Model model, @ModelAttribute(value = "animale") AnimalePojo animale) {
            model.addAttribute("animale", animale);
        if (!animale.getNome().matches("^[0-9]*$") && !animale.getNomePadrone().matches("^[0-9]*$")) {
            Animale newAnimal = animaleFacade.save(animale);
            return "redirect:/animale/findAll";
        }else {
            model.addAttribute("animale", new AnimalePojo());
            return "/insert";
        }
    }

    @GetMapping(value = "/del/{id}")
    private String del(@PathVariable String id){
        animaleFacade.delete(id);
        return "redirect:/animale/findAll";
    }
}
