package com.egg.servicios;

import com.egg.entidades.Autor;
import com.egg.persistencia.AutorDAO;

public class AutorServicio {
    private final AutorDAO autorDao;

    public AutorServicio() {
        this.autorDao = new AutorDAO();
    }

    public void crearAutor(Autor autor) {
        autorDao.guardar(autor);
    }

    public Autor obtenerAutorPorId(int id) {
        return autorDao.buscarPorId(id);
    }

    public void actualizarAutor(Autor autor) {
        autorDao.actualizar(autor);
    }

    public void darDeBajaAutor(int id) {
        autorDao.darDeBaja(id);
    }

    public void cerrar() {
        autorDao.cerrar();
    }
}
