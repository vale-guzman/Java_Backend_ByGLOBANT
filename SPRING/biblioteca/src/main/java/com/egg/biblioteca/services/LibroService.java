package com.egg.biblioteca.services;

import com.egg.biblioteca.entities.Autor;
import com.egg.biblioteca.entities.Editorial;
import com.egg.biblioteca.entities.Libro;
import com.egg.biblioteca.repositories.AutorRepositorio;
import com.egg.biblioteca.repositories.EditorialRepositorio;
import com.egg.biblioteca.repositories.LibroRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LibroService {

    @Autowired
    private LibroRepositorio libroRepositorio;
    @Autowired
    private AutorRepositorio autorRepositorio;
    @Autowired
    private EditorialRepositorio editorialRepositorio;

    @Transactional
    public void crearLibro(Long isbn, String titulo, int ejemplares, UUID idAutor, UUID idEditorial){

        Autor autor= autorRepositorio.findById(idAutor).get();
        Editorial editorial=editorialRepositorio.findById(idEditorial).get();

        Libro libro=new Libro();

        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setEjemplares(ejemplares);
        libro.setAlta(new Date());
        libro.setAutor(autor);
        libro.setEditorial(editorial);

        libroRepositorio.save(libro);

    }

    public List<Libro>listarLibros(){
        List<Libro> listaLibros= new ArrayList<>();
        listaLibros=libroRepositorio.findAll();
        return  listaLibros;
    }

    @Transactional
    public void modificarLibro(String titulo, int ejemplares, UUID idAutor, UUID idEditorial, Long isbn){
        Optional<Libro> respuesta= libroRepositorio.findById(isbn);

        if(respuesta.isPresent()){
            Libro libroEncontrado=respuesta.get();

            libroEncontrado.setTitulo(titulo);
            libroEncontrado.setEjemplares(ejemplares);
            libroEncontrado.setAutor(autorRepositorio.findById(idAutor).get());
            libroEncontrado.setEditorial(editorialRepositorio.findById(idEditorial).get());

            libroRepositorio.save(libroEncontrado);
        }
    }
}
