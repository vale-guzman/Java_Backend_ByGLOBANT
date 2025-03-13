package com.egg.biblioteca.services;

import com.egg.biblioteca.entities.Autor;
import com.egg.biblioteca.exceptions.MyException;
import com.egg.biblioteca.repositories.AutorRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AutorService {
    @Autowired
    AutorRepositorio autorRepositorio;

    @Transactional
    public void crearAutor(String nombre) throws MyException {
        validar(nombre);
        Autor autor=new Autor();
        autor.setNombre(nombre);

        autorRepositorio.save(autor);
    }
    public List<Autor> listarAutores(){
        List<Autor> listaAutores=new ArrayList<>();

        listaAutores=autorRepositorio.findAll();

        return listaAutores;
    }

    @Transactional
    public void modificarAutor(String nombre, UUID id)throws MyException{
       validar(nombre);

        Optional<Autor> respuesta=autorRepositorio.findById(id);
        if(respuesta.isPresent()){
            Autor autorEncontrado= respuesta.get();

            autorEncontrado.setNombre(nombre);
            autorRepositorio.save(autorEncontrado);
        }
    }

    private void validar(String nombre)throws MyException{
            if (nombre == null|| nombre.isEmpty()) {
                throw new MyException("El NOMBRE no puede ser NULO");
            }
    }

    @Transactional
    public Autor getOne(UUID id){
        return autorRepositorio.findById(id).orElse(null);
    }
}
