package com.api.clinica.controllers;

import com.api.clinica.entities.Animale;
import com.api.clinica.entities.Visita;
import com.api.clinica.entities.pojo.AnimalePojo;
import com.api.clinica.entities.pojo.VisitaPojo;
import com.api.clinica.facades.AnimaleFacade;
import com.api.clinica.facades.VisitaFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/visita")
public class VisitaController {
    @Autowired
    private VisitaFacade visitaFacade;
    @Autowired
    AnimaleFacade animaleFacade;

    @GetMapping(value = "/scheda/{id}")
    private String findByIdAnimale(Model model, @PathVariable String id) {
        Animale animale = animaleFacade.findById(id);
        model.addAttribute("animale", animale);
        List<Visita> visiteList = visitaFacade.findByIdAnimale(id);
        model.addAttribute("visite", visiteList);
        return "view";
    }
    @GetMapping(value = "/insert/{id}")
    private String insPage(Model model, @PathVariable String id) {
        VisitaPojo data = new VisitaPojo();
        data.setIdAnimale(Long.valueOf(id));
        model.addAttribute("visita", data);
        return "newvisita";
    }
    @GetMapping(value = "/edit/{id}")
    private String editPage(Model model, @PathVariable String id) {
        Animale data = animaleFacade.findById(id);
        model.addAttribute("animale", data);
        return "edit";
    }
    @PostMapping(value = "/saveEdit/{id}")
    private String save(Model model, @ModelAttribute(value = "visita") Visita data, @PathVariable String id) {
        model.addAttribute("visita", data);
        if (!data.getTipologia().matches("^[0-9]*$")) {
//            Animale newAnimal = animaleFacade.edit(, id);
            return "redirect:/animale/findAll";
        }else {
            model.addAttribute("animale", new AnimalePojo());
            return "/insert";
        }
    }
    @PostMapping(value = "/save/{id}")
    private String save(Model model, @ModelAttribute(value = "visita") VisitaPojo data, @PathVariable String id) {
        model.addAttribute("visita", data);
        if (!data.getTipologia().matches("^[0-9]*$")) {
            Animale animale= animaleFacade.findById(id);
            final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            final LocalDate localDate = LocalDate.parse(data.getData(), formatter);
            Visita visita= new Visita(null, data.getTipologia(), localDate, animale);
            Visita newVisita = visitaFacade.save(visita);
            return "redirect:/visita/scheda/"+id;
        }else {
            model.addAttribute("visita", new Visita());
            return "/insert/"+id;
        }
    }

    @GetMapping(value = "/del")
    private String del(@RequestParam(value = "idAnimale") String idAnimale, @RequestParam(value = "id") String id){
        visitaFacade.delete(id);
        return "redirect:/visita/scheda/"+idAnimale;
    }
}
