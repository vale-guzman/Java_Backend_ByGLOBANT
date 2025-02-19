package com.egg.persistencia;

import com.egg.entidades.Autor;
import com.egg.entidades.Editorial;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class AutorDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("libreriaPU");
    private EntityManager em = emf.createEntityManager();

    public void guardar(Autor autor) {
        em.getTransaction().begin();
        em.persist(autor);
        em.getTransaction().commit();
    }

    public Autor buscarPorId(int id) {
        return em.find(Autor.class, id);
    }

    public void actualizar(Autor autor) {
        em.getTransaction().begin();
        em.merge(autor);
        em.getTransaction().commit();
    }
    public List<Autor> listarTodos() {
        List<Autor> autores = null;
        try {
            autores = em.createQuery("SELECT a FROM Autor a", Autor.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return autores;
    }
    public void darDeBaja(int id) {
        Autor autor = buscarPorId(id);
        if (autor != null) {
            em.getTransaction().begin();
            autor.setAlta(false);
            em.merge(autor);
            em.getTransaction().commit();
        }
    }

    public void cerrar() {
        em.close();
        emf.close();
    }
}
