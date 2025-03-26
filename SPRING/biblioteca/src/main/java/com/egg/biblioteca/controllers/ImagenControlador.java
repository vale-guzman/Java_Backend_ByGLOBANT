package com.egg.biblioteca.controllers;

import com.egg.biblioteca.entities.Usuario;
import com.egg.biblioteca.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/imagen")
public class ImagenControlador {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/perfil/{id}")
    public ResponseEntity<byte[]> imagenUsuario(@PathVariable UUID id){ //recibe el id de la imagen del usuario

        //buscamos al usuario que tiene ese id.
        Usuario usuario=usuarioService.getOne(id);

        //cadena de bytes de la imagen del usuario
        byte[] imagen = usuario.getImagen().getContenido();

        //cabecera del pedido, le dice al navegador, que lo que devolvemos es una imagen
        HttpHeaders headers= new HttpHeaders();

        //seteamos el contenido como una imagen jpeg.
        headers.setContentType(MediaType.IMAGE_JPEG);

        //retorna RespondeEntity: tiene un arreglo de Bytes (nuestra imagen del usuario)
        //recibe 3 parámetros
        return new ResponseEntity<>(imagen,headers, HttpStatus.OK);
    }
}
