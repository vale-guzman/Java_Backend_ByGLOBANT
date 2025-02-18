package com.egg.servicios;

import com.egg.entidades.Libro;
import com.egg.persistencia.LibroDAO;

public class LibroServicio {
    private final LibroDAO libroDao;

    public LibroServicio() {   this.libroDao = new LibroDAO();  }

    public void crearLibro(Libro libro) {
        libroDao.guardar(libro);
    }

    public Libro obtenerLibroPorIsbn(Long isbn) {
        return libroDao.buscarPorIsbn(isbn);
    }

    public void actualizarLibro(Libro libro) {
        libroDao.actualizar(libro);
    }

    public void darDeBajaLibro(Long isbn) {
        libroDao.darDeBaja(isbn);
    }

    public void cerrar() {
        libroDao.cerrar();
    }
}
