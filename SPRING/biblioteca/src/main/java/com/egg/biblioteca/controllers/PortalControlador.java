package com.egg.biblioteca.controllers;

import com.egg.biblioteca.entities.Imagen;
import com.egg.biblioteca.entities.Usuario;
import com.egg.biblioteca.exceptions.MyException;
import com.egg.biblioteca.services.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Controller
@RequestMapping("/")
public class PortalControlador {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @GetMapping("/registrar")
    //@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public String registrar() {
        return "registro.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam MultipartFile archivo,
                           @RequestParam String nombre, @RequestParam String email,
                           @RequestParam String password, @RequestParam String password2,
                           ModelMap modelMap) {
        try {
            usuarioService.registrar(archivo, nombre, email, password, password2);
            modelMap.put("exito", "Usuario registrado Correctamente");
            return "index.html";
        } catch (MyException ex) {
            modelMap.put("error", ex.getMessage());
            modelMap.put("nombre", nombre);
            modelMap.put("email", email);

            return "registro.html"; //Volvemos a cargar el formulario
        }
    }

    @GetMapping("/login")
    //puede o no venir un error, por esto el RequestParam es required=false
    public String login(@RequestParam(required = false) String error, ModelMap modelmap) {
        if (error != null) {
            modelmap.put("error", "Usuario o Contraseña inválidos!");
        }
        return "login.html";
    }

    @GetMapping("/inicio")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')") // indicamos que pueden ingresar a esta URL (/inicio) solo si
    // estamos logueados.
    // este método recibe un objeto tipo HttpSession.
    public String inicio(HttpSession session) {

        //Creamos un usuario que tiene todos los datos de la sesión a través del atributo llave "usuariosession".
        Usuario logueado = (Usuario) session.getAttribute("usuariosession");

        //validamos qué tipo de usuario está logueado, y así direccionamos.
        if (logueado.getRol().toString().equals("ADMIN")) {
            return "redirect:/admin/dashboard";
        }
        return "inicio.html";
    }

    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping("/perfil")
    public String perfil(ModelMap modelMap, HttpSession httpSession) {

        //Creo un usuario y le guardo todos los datos del User que está logueado.
        Usuario usuario = (Usuario) httpSession.getAttribute("usuariosession");

        modelMap.put("usuario", usuario);

        return "usuario_modificar.html";
    }

    @GetMapping("/logout")
    public String logout() {
        return "login.html";
    }

}
