package com.egg.persistencia;

import com.egg.entidades.Editorial;
import com.egg.entidades.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class LibroDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("libreriaPU");
    private EntityManager em = emf.createEntityManager();

    public void guardar(Libro libro) {
        em.getTransaction().begin();
        em.persist(libro);
        em.getTransaction().commit();
    }

    public Libro buscarPorIsbn(Long isbn) {
        return em.find(Libro.class, isbn);
    }

    public void actualizar(Libro libro) {
        em.getTransaction().begin();
        em.merge(libro);
        em.getTransaction().commit();
    }
    public List<Libro> listarTodos() {
        List<Libro> libros = null;
        try {
            libros = em.createQuery("SELECT l FROM Libro l", Libro.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return libros;
    }
    public void darDeBaja(Long isbn) {
        Libro libro = buscarPorIsbn(isbn);
        if (libro != null) {
            em.getTransaction().begin();
            libro.setAlta(false);
            em.merge(libro);
            em.getTransaction().commit();
        }
    }

    public void cerrar() {
        em.close();
        emf.close();
    }
}
