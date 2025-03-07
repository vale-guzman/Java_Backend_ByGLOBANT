package com.egg.biblioteca.controllers;

import com.egg.biblioteca.entities.Autor;
import com.egg.biblioteca.entities.Editorial;
import com.egg.biblioteca.exceptions.MyException;
import com.egg.biblioteca.services.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
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
                           ModelMap modelMap) {
        try {
            editorialService.crearEditorial(nombre);
            modelMap.put("exito", "La Editorial fué cargada Correctamente");
        } catch (MyException ex) {
            Logger.getLogger(EditorialControlador.class.getName()).log(Level.SEVERE, null, ex);
            modelMap.put("error", ex.getMessage());
            return "editorial_form.html";
        }
        return "index.html";
    }

    @GetMapping("/listar") // http://localhost:8080/editorial/listar
    public String listar (ModelMap modelMap){

        List<Editorial> editoriales = editorialService.listarEditoriales();
        modelMap.addAttribute("editoriales", editoriales);
        return "editorial_list.html";

    }

    @GetMapping ("/modificar/{id}") //localhost:8080/editorial/modificar
    public String modificar(@PathVariable UUID id,
                            ModelMap modelMap){
        editorialService.getOne(id);
        modelMap.put("editorial",editorialService.getOne(id));
        return "editorial_modificar.html";
    }

    @PostMapping ("/modificar/{id}")
    public String modificar(@PathVariable UUID id,
                            String nombre, ModelMap modelMap){
        try{

            editorialService.modificarEditorial(nombre, id);
            modelMap.put("exito","La Editorial fué Modificada Correctamente");
            return "redirect:../listar";
        }catch (MyException ex){
            Logger.getLogger(AutorControlador.class.getName()).log(Level.SEVERE,null, ex);
            modelMap.put("error", ex.getMessage());
            return "editorial_modificar.html";
        }
    }
}
