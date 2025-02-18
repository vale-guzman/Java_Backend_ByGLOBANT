package com.egg.persistencia;

import com.egg.entidades.Editorial;
import com.egg.entidades.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EditorialDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("libreriaPU");
    private EntityManager em = emf.createEntityManager();

    public void guardar(Editorial editorial) {
        em.getTransaction().begin();
        em.persist(editorial);
        em.getTransaction().commit();
    }

    public Editorial buscarPorId(int id) {
        return em.find(Editorial.class, id);
    }

    public void actualizar(Editorial editorial) {
        em.getTransaction().begin();
        em.merge(editorial);
        em.getTransaction().commit();
    }

    public void darDeBaja(int id) {
        Editorial editorial = buscarPorId(id);
        if (editorial != null) {
            em.getTransaction().begin();
            editorial.setAlta(false);
            em.merge(editorial);
            em.getTransaction().commit();
        }
    }

    public void cerrar() {
        em.close();
        emf.close();
    }
}
