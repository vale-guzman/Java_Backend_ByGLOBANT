package com.egg.biblioteca.controllers;

import com.egg.biblioteca.exceptions.MyException;
import com.egg.biblioteca.services.AutorService;
import com.egg.biblioteca.services.EditorialService;
import com.egg.biblioteca.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@RequestMapping("/libro") //http://localhost:8080/editorial
public class LibroControlador {
    @Autowired
    private LibroService libroService;

    @Autowired
    private AutorService autorService;

    @Autowired
    private EditorialService editorialService;

    @GetMapping("/registrar")//localhost:8080/libro/registrar
    public String registrar(){
        return "libro_form.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam(required = false) Long isbn, @RequestParam String titulo,
                           @RequestParam(required = false) Integer ejemplares, @RequestParam UUID idAutor,
                           @RequestParam UUID idEditorial,
                           ModelMap modelMap) {
        try {
            libroService.crearLibro(isbn, titulo, ejemplares, idAutor, idEditorial);
            modelMap.put("exito","El Libro fué cargado Correctamente");

        } catch (MyException ex) {
            modelMap.put("error", ex.getMessage());
            return "libro_form.html"; // volvemos a cargar el formulario.
        }
        return "index.html";
    }
}
