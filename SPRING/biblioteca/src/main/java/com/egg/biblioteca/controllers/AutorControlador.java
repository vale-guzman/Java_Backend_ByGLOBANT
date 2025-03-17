package com.egg.biblioteca.controllers;

import com.egg.biblioteca.entities.Autor;
import com.egg.biblioteca.exceptions.MyException;
import com.egg.biblioteca.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
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
    public String registro(@RequestParam String nombre,
                           ModelMap modelMap){
        try{
           autorService.crearAutor(nombre);
           modelMap.put("exito","El Autor fué cargado Correctamente");
        }catch (MyException ex){
          Logger.getLogger(AutorControlador.class.getName()).log(Level.SEVERE,null, ex);
           modelMap.put("error", ex.getMessage());
            return "autor_form.html";
        }
        return "index.html";
    }

    @GetMapping("/listar") // http://localhost:8080/autor/listar
    public String listar (ModelMap modelMap){

        List<Autor> autores = autorService.listarAutores();
        modelMap.addAttribute("autores", autores);
        return "autor_list.html";

    }

    @GetMapping ("/modificar/{id}") //localhost:8080/autor/modificar
    public String modificar(@PathVariable UUID id,  //PathVariable: lo uso porque
                            ModelMap modelMap){     // el id viaja através de un fragmento de la URL

        autorService.getOne(id);
        modelMap.put("autor",autorService.getOne(id));
        return "autor_modificar.html";
    }

    @PostMapping ("/modificar/{id}")
    public String modificar(@PathVariable UUID id,
                            String nombre, ModelMap modelMap){
        try{

            autorService.modificarAutor(nombre, id);
            modelMap.put("exito","El Autor fué Modificado Correctamente");
            return "redirect:../listar";
        }catch (MyException ex){
            Logger.getLogger(AutorControlador.class.getName()).log(Level.SEVERE,null, ex);
            modelMap.put("error", ex.getMessage());
            return "autor_modificar.html";
        }
    }
}
