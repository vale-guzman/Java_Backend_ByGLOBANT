package com.egg.biblioteca.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminControlador {

    @GetMapping ("/dashboard")  //Por protocolo, para aquellos paneles que utilizan los administradores.
    public String panelAdministrativo(){
        return  "panel_form.html";
    }
}
