package com.egg.biblioteca.services;

import com.egg.biblioteca.entities.Autor;
import com.egg.biblioteca.entities.Editorial;
import com.egg.biblioteca.entities.Libro;
import com.egg.biblioteca.exceptions.MyException;
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
    public void crearLibro (Long isbn, String titulo, Integer ejemplares, UUID idAutor, UUID idEditorial)throws MyException{

        //Llamo al método validar de esta clase
        validar(isbn, titulo, ejemplares, idAutor, idEditorial);

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
    public void modificarLibro(String titulo, int ejemplares, UUID idAutor, UUID idEditorial, Long isbn)throws MyException{

        //Llamo al método validar de esta clase
        validar(isbn, titulo, ejemplares, idAutor, idEditorial);

        Optional<Libro> respLibro= libroRepositorio.findById(isbn);
        Optional<Autor> respAutor=autorRepositorio.findById(idAutor);
        Optional<Editorial> respEditorial=editorialRepositorio.findById(idEditorial);

        Autor autor=new Autor();
        Editorial editorial=new Editorial();

        if (respAutor.isPresent()){
            autor=respAutor.get();
        }
        if (respEditorial.isPresent()){
            editorial=respEditorial.get();
        }

        if(respLibro.isPresent()){
            Libro libroEncontrado=respLibro.get();

            libroEncontrado.setTitulo(titulo);
            libroEncontrado.setEjemplares(ejemplares);
            libroEncontrado.setAutor(autor);
            libroEncontrado.setEditorial(editorial);

            libroRepositorio.save(libroEncontrado);
        }
    }

    private void validar (Long isbn, String titulo, Integer ejemplares, UUID idAutor, UUID idEditorial) throws MyException{
        if (isbn==null){
            throw new MyException("El ISBN no puede ser NULO.");
        }
        if(titulo==null || titulo.isEmpty()){
            throw new MyException("El TÍTULO no puede ser NULO");
        }
        if(ejemplares==null){
            throw new MyException("Los EJEMPLARES no pueden ser NULOS");
        }
        if (idAutor==null){
            throw new MyException("El AUTOR no puede ser NULO");
        }
        if (idEditorial==null){
            throw new MyException("La EDITORIAL no puede ser NULA");
        }
    }
}
