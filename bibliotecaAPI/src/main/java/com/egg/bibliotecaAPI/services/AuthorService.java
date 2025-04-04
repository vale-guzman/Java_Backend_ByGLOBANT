package com.egg.bibliotecaAPI.services;

import com.egg.bibliotecaAPI.entities.Author;
import com.egg.bibliotecaAPI.repositories.AuthorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Transactional
    public void createAuthor(String nombre) {

        Author author=new Author();
        author.setNombre(nombre);

        authorRepository.save(author);
    }

    public List<Author> listarAutores(){

        List<Author> listAuthors=new ArrayList<>();
        listAuthors=authorRepository.findAll();

        return listAuthors;
    }

    @Transactional
    public void modificarAutor(String nombre, UUID id){

        Optional<Author> respuesta=authorRepository.findById(id);
        if(respuesta.isPresent()){
            Author autorEncontrado= respuesta.get();

            autorEncontrado.setNombre(nombre);
            authorRepository.save(autorEncontrado);
        }
    }

    public void deleteAuthor(UUID id) {

            Author autor = authorRepository.findById(id).get();
            if (autor != null) {
                autor.setActivo(false);
                authorRepository.save(autor);
            }
        }

   /* @Transactional
    public void eliminarAutor(UUID id) throws MiException {
        Autor autor = autorRepositorio.findById(id)
                .orElseThrow(() -> new MiException("No se encontró el autor en la base de datos"));

        autor.setActivo(false);
        autorRepositorio.save(autor);
    }*/

    @Transactional
    public Author getOne(UUID id){
        return authorRepository.findById(id).orElse(null);
    }
}
