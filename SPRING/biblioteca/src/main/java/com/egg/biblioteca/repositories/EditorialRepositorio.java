package com.egg.biblioteca.repositories;

import com.egg.biblioteca.entities.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EditorialRepositorio extends JpaRepository<Editorial, UUID> {

    @Query("select e.nombre from Editorial e where e.nombre like %:nombre")
    public List<Editorial> findEditorialsByNombre(@Param("nombre") String nombre);
}
