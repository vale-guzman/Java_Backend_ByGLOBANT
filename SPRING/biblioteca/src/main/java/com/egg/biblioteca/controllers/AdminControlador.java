package com.egg.biblioteca.controllers;

import com.egg.biblioteca.entities.Libro;
import com.egg.biblioteca.entities.Usuario;
import com.egg.biblioteca.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class AdminControlador {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping ("/dashboard")  //Por protocolo, para aquellos paneles que utilizan los administradores.
    public String panelAdministrativo(){
        return  "panel_form.html";
    }

    @GetMapping("/usuarios") // http://localhost:8080/admin/usuarios
    public String listar(ModelMap modelMap){
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        modelMap.addAttribute("usuarios", usuarios);
        return "usuario_list.html";
    }

    @GetMapping("modificarRol/{id}")
    public String cambiarRol(@PathVariable UUID id){
        usuarioService.cambiarRol(id);
        return "redirect:/admin/usuarios";
    }
}
