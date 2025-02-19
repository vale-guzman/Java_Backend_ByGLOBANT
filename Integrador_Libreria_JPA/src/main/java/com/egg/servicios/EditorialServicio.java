package com.egg.servicios;

import com.egg.entidades.Editorial;
import com.egg.persistencia.EditorialDAO;

import java.util.List;

public class EditorialServicio {
    private final EditorialDAO editorialDao;

    public EditorialServicio() {
        this.editorialDao = new EditorialDAO();
    }

    public void crearEditorial(String nombre, boolean alta) {

        try {
            // Crear una nueva instancia de Editorial
        Editorial editorialNueva= new Editorial();

        editorialNueva.setNombre(nombre);
        editorialNueva.setAlta(alta);
            editorialDao.guardar(editorialNueva);

        } catch (Exception e) {
            System.out.println(e.toString() + "❌No se guardo la Nueva Editorial de manera correcta");
            System.out.println(e.getMessage());
        }
    }

    public Editorial obtenerEditoriaPorId(int id) {
        return editorialDao.buscarPorId(id);
    }

    public void listarEditoriales(){
        List<Editorial> editoriales=editorialDao.listarTodos();
        if (editoriales.isEmpty()) {
            System.out.println("No hay editoriales registradas.");
        } else {
            for (Editorial editorial : editoriales) {
                System.out.println("ID: " + editorial.getId() + ", Nombre: " + editorial.getNombre()
                        + ", Alta: " + editorial.isAlta());
            }
        };
    }
    public void actualizarEditorial(Editorial editorial) {
        editorialDao.actualizar(editorial);
    }

    public void darDeBajaEditorial(int id) {
        editorialDao.darDeBaja(id);
    }

    public void cerrar() {
        editorialDao.cerrar();
    }
}
