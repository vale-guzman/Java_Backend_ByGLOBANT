package com.egg.biblioteca.controllers;

import com.egg.biblioteca.exceptions.MyException;
import com.egg.biblioteca.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class PortalControlador {

    @Autowired
    private UsuarioService usuarioService;
    @GetMapping("/")
    public String index(){
        return "index.html";
    }

    @GetMapping("/registrar")
    public String registrar(){
        return "registro.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, @RequestParam String email,
                           @RequestParam String password, @RequestParam String password2,
                           ModelMap modelMap){
        try{
            usuarioService.registrar(nombre, email, password, password2);
            modelMap.put("exito","Usuario registrado Correctamente" );
                    return "index.html";
        }catch (MyException ex){
            modelMap.put("error", ex.getMessage());
            return "registro.html"; //Volvemos a cargar el formulario
        }
    }
    @GetMapping("/login")
    public String login(){
        return "login.html";
    }


}
