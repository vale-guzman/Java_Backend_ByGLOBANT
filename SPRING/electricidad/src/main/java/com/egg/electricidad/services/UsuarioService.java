package com.egg.electricidad.services;

import com.egg.electricidad.entidades.Usuario;
import com.egg.electricidad.repositorios.UsuarioRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

    @Service
    public class UsuarioService {
        @Autowired
        private UsuarioRepositorio usuarioRepositorio;

        @Transactional
        public void guardarUsuario(String email, String nombre, String apellido, String password, String claveConfirmar) {
            if (email == null || email.trim().isEmpty()) {
                throw new IllegalArgumentException("El email es obligatorio");
            }

            if (getOne(email) != null) {
                throw new IllegalArgumentException("El email ya está registrado");
            }

            if (nombre == null || nombre.trim().isEmpty()) {
                throw new IllegalArgumentException("El nombre es obligatorio");
            }

            if (password == null || password.length() <= 5) {
                throw new IllegalArgumentException("La contraseña debe tener al menos 5 caracteres");
            }

            if (claveConfirmar == null || !password.equals(claveConfirmar)) {
                throw new IllegalArgumentException("La contraseña es incorrecta");
            }

            // Guardar datos del usuario
            Usuario usr = new Usuario();
            usr.setEmail(email);
            usr.setNombre(nombre);
            usr.setApellido(apellido);
            usr.setPassword(password);

            // Insertar usuario
            usuarioRepositorio.save(usr);
        }

        public Usuario getOne(String email){
            return usuarioRepositorio.findByEmail(email);
        }
    }

