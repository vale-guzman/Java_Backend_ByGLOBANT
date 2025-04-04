package com.egg.biblioteca.services;

import com.egg.biblioteca.entities.Autor;
import com.egg.biblioteca.entities.Editorial;
import com.egg.biblioteca.exceptions.MyException;
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
    public void crearEditorial(String nombre) throws MyException {
        validar(nombre);

        Editorial editorial = new Editorial();
        editorial.setNombre(nombre);

        editorialRepositorio.save(editorial);
    }

    public List<Editorial> listarEditoriales() {
        List<Editorial> listaEditoriales = new ArrayList<>();
        listaEditoriales = editorialRepositorio.findAll();

        return listaEditoriales;
    }

    @Transactional
    public void modificarEditorial(String nombre, UUID id) throws MyException {
        validar(nombre);
        Optional<Editorial> respuesta = editorialRepositorio.findById(id);

        if (respuesta.isPresent()) {
            Editorial editorialEncontrada = respuesta.get();

            editorialEncontrada.setNombre(nombre);
            editorialRepositorio.save(editorialEncontrada);
        }
    }

    private void validar(String nombre) throws MyException {
        if (nombre == null || nombre.isEmpty()) {
            throw new MyException("El NOMBRE no puede ser NULO");
        }
    }
    @Transactional()
    public Editorial getOne(UUID id){
        return editorialRepositorio.findById(id).orElse(null);
    }
}
