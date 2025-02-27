package com.egg.biblioteca.services;

import com.egg.biblioteca.entities.Autor;
import com.egg.biblioteca.entities.Editorial;
import com.egg.biblioteca.repositories.AutorRepositorio;
import com.egg.biblioteca.repositories.EditorialRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EditorialService {

    @Autowired
    EditorialRepositorio editorialRepositorio;
    @Transactional
    public void crearEditorial(String nombre) {
        Editorial editorial=new Editorial();
        editorial.setNombre(nombre);

        editorialRepositorio.save(editorial);
    }

   public List<Editorial> listarEditoriales(){
        List<Editorial> listaEditoriales=new ArrayList<>();
        listaEditoriales= editorialRepositorio.findAll();

        return listaEditoriales;
    }

   @Transactional
   public void modificarEditorial(String nombre, UUID id){
       Optional<Editorial> respuesta= editorialRepositorio.findById(id);

       if (respuesta.isPresent()){
           Editorial editorialEncontrada=respuesta.get();

           editorialEncontrada.setNombre(nombre);
           editorialRepositorio.save(editorialEncontrada);
       }
   }
}
