package com.egg.servicios;

import com.egg.entidades.Editorial;
import com.egg.persistencia.EditorialDAO;

public class EditorialServicio {
    private final EditorialDAO editorialDao;

    public EditorialServicio() {
        this.editorialDao = new EditorialDAO();
    }

    public void crearEditorial(Editorial editorial) {
        editorialDao.guardar(editorial);
    }

    public Editorial obtenerEditoriaPorId(int id) {
        return editorialDao.buscarPorId(id);
    }

    public void actualizarEditorial(Editorial editorial) {
        editorialDao.actualizar(editorial);
    }

    public void darDeBajaEditori(int id) {
        editorialDao.darDeBaja(id);
    }

    public void cerrar() {
        editorialDao.cerrar();
    }
}
