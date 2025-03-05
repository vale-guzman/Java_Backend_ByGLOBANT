package com.egg.biblioteca.controllers;

import com.egg.biblioteca.exceptions.MyException;
import com.egg.biblioteca.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping("/autor")  // http://localhost:8080/autor
public class AutorControlador {

    @Autowired
    private AutorService autorService;

    @GetMapping("/registrar") // http://localhost:8080/autor/registrar
    public String registrar(){
        return "autor_form.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre){

        try{
           autorService.crearAutor(nombre);
        }catch (MyException ex){
          Logger.getLogger(AutorControlador.class.getName()).log(Level.SEVERE,null, ex);
            return "autor_form.html";
        }
        return "index.html";
    }
}
