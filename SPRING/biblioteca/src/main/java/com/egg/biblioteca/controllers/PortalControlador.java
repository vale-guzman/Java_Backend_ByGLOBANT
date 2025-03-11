package com.egg.biblioteca.controllers;

import com.egg.biblioteca.entities.Usuario;
import com.egg.biblioteca.exceptions.MyException;
import com.egg.biblioteca.services.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
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
    //puede o no venir un error, por esto el RequestParam es required=false
    public String login(@RequestParam(required = false) String error, ModelMap modelmap){
        if (error != null) {
            modelmap.put("error", "Usuario o Contraseña inválidos!");
        }
        return "login.html";
    }

    @GetMapping ("/inicio")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')") // indicamos que pueden ingresar a esta URL (/inicio) solo si
                                                            // estamos logueados.
    public String inicio(HttpSession session){
        Usuario logueado = (Usuario) session.getAttribute("usuariosession");
        if (logueado.getRol().toString().equals("ADMIN")) {
            return "redirect:/admin/dashboard";
        }
        return "inicio.html";
    }


}
