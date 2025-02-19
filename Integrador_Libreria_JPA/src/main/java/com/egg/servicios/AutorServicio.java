package com.egg.servicios;

import com.egg.entidades.Autor;
import com.egg.entidades.Editorial;
import com.egg.persistencia.AutorDAO;

import java.util.List;

public class AutorServicio {
    private final AutorDAO autorDao;

    public AutorServicio() {
        this.autorDao = new AutorDAO();
    }

    public void crearAutor(String nombre, boolean alta) {
        try {
            // Crear una nueva instancia de Autor
            Autor autorNuevo= new Autor();

            autorNuevo.setNombre(nombre);
            autorNuevo.setAlta(alta);
            autorDao.guardar(autorNuevo);

        } catch (Exception e) {
            System.out.println(e.toString() + "❌No se guardo el nuevo Autor de manera correcta");
        }
    }

    public Autor obtenerAutorPorId(int id) {
        return autorDao.buscarPorId(id);
    }

    public void actualizarAutor(Autor autor) {
        autorDao.actualizar(autor);
    }
    public void listarAutores(){
        List<Autor> autores=autorDao.listarTodos();
        if (autores.isEmpty()) {
            System.out.println("No hay Autores registrados.");
        } else {
            for (Autor autor : autores) {
                System.out.println("ID: " + autor.getId() + ", Nombre: " + autor.getNombre()
                        + ", Alta: " + autor.isAlta());
            }
        };
    }

    public void darDeBajaAutor(int id) {
        autorDao.darDeBaja(id);
    }

    public void cerrar() {
        autorDao.cerrar();
    }
}
