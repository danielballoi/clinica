package com.api.clinica.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    private String home() {
        return "redirect:/animale/findAll";
    }

}
