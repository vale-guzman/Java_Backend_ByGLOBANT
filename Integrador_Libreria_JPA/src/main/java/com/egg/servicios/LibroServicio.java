package com.egg.servicios;

import com.egg.entidades.Autor;
import com.egg.entidades.Editorial;
import com.egg.entidades.Libro;
import com.egg.persistencia.LibroDAO;

import java.util.List;

public class LibroServicio {
    private final LibroDAO libroDao;

    public LibroServicio() {   this.libroDao = new LibroDAO();  }

    public void crearLibro(Long id,String tit,int y, int stock,boolean b) {
        try {
            // Crear una nueva instancia de Libro
            Libro libroNuevo = new Libro();
            libroNuevo.setIsbn(id);
            libroNuevo.setTitulo(tit);
            libroNuevo.setAnio(y);
            libroNuevo.setEjemplares(stock);
            libroNuevo.setAlta(b);
            libroNuevo.setAutor(null);
            libroNuevo.setEditorial(null);
            libroDao.guardar(libroNuevo);

        } catch (Exception e) {
            System.out.println(e.toString() + "❌No se guardo el nuevo Autor de manera correcta");
        }

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

    public void listarLibros(){
        List<Libro> libros=libroDao.listarTodos();
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
        } else {
            for (Libro libro : libros) {
                System.out.println("ISBN: " + libro.getIsbn() + ", Título: " + libro.getTitulo()
                        + ", Alta: " + libro.isAlta() + " Ejemplares: "+ libro.getEjemplares()
                        + " Año Edición: " + libro.getAnio() + " Autor: " + libro.getAutor()
                        + " Editorial: "+ libro.getEditorial());
            }
        };
    }
    public void cerrar() {
        libroDao.cerrar();
    }
}
