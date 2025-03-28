package com.egg.biblioteca.controllers;

import com.egg.biblioteca.entities.Libro;
import com.egg.biblioteca.entities.Usuario;
import com.egg.biblioteca.exceptions.MyException;
import com.egg.biblioteca.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class AdminControlador {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/dashboard")  //Por protocolo, para aquellos paneles que utilizan los administradores.
    public String panelAdministrativo() {
        return "panel_form.html";
    }

    @GetMapping("/usuarios") // http://localhost:8080/admin/usuarios
    public String listar(ModelMap modelMap) {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        modelMap.addAttribute("usuarios", usuarios);
        return "usuario_list.html";
    }

    @GetMapping("modificarRol/{id}")
    public String cambiarRol(@PathVariable UUID id) {
        usuarioService.cambiarRol(id);
        return "redirect:/admin/usuarios";
    }
    @GetMapping("/modificar/{id}")
    public String modificarUsuario(@PathVariable UUID id, ModelMap modelo){
        Usuario usuario = usuarioService.getOne(id);
        modelo.addAttribute("usuario", usuario);

        return "usuario_modificar.html";
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping("/modificar/{id}")
    public String actualizar(MultipartFile archivo, @PathVariable UUID id, @RequestParam String nombre, @RequestParam String email,
                             @RequestParam String password, @RequestParam String password2, ModelMap modelo) {

        try {
            usuarioService.actualizar(archivo, id, nombre, email, password, password2);
            modelo.put("exito", "El usuario fue actualizado correctamente.");
            return "redirect:/admin/usuarios";

        } catch (MyException ex) {
            modelo.put("error", ex.getMessage());
            modelo.put("nombre", nombre);
            modelo.put("email", email);
            modelo.put("password",password);
            modelo.put("password2",password2);
            return "usuario_modificar.html";
        }

    }
}
