package com.egg.biblioteca.controllers;

import com.egg.biblioteca.exceptions.MyException;
import com.egg.biblioteca.services.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping("/editorial") // http://localhost:8080/editorial
public class EditorialControlador {

    @Autowired
    private EditorialService editorialService;


    @GetMapping("/registrar") // http://localhost:8080/editorial/registrar
    public String registrar(){
        return "editorial_form.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre,
                           ModelMap modelMap){
       try {
        editorialService.crearEditorial(nombre);
        modelMap.put("exito","La Editorial fué cargada Correctamente");
    }catch (MyException ex){
           Logger.getLogger(EditorialControlador.class.getName()).log(Level.SEVERE,null, ex);
           modelMap.put("error", ex.getMessage());
           return "editorial_form.html";
    }
        return "index.html";
}
}
