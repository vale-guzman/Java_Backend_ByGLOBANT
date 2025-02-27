package com.egg.biblioteca.services;

import com.egg.biblioteca.entities.Autor;
import com.egg.biblioteca.entities.Editorial;
import com.egg.biblioteca.repositories.AutorRepositorio;
import com.egg.biblioteca.repositories.EditorialRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;

@Service
public class EditorialService {

    @Autowired
    EditorialRepositorio editorialRepositorio;
    @Transactional
    public void crearEditorial(String nombre)
    {
        Editorial editorial=new Editorial();
        editorial.setNombre(nombre);

        editorialRepositorio.save(editorial);
    }
}
