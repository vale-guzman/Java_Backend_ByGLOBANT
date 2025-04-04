package com.egg.bibliotecaAPI.controllers;

import com.egg.bibliotecaAPI.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {

    //Instancio el servicio para acceder a sus métodos
    @Autowired
    AuthorService authorService;

    @PostMapping("crear")
    public ResponseEntity<Object> crearAutor(String nombre){
        try{
            authorService.createAuthor(nombre);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
