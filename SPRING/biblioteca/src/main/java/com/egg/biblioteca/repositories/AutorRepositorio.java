package com.egg.biblioteca.repositories;

import com.egg.biblioteca.entities.Autor;
import com.egg.biblioteca.entities.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AutorRepositorio extends JpaRepository <Autor, UUID>{
    @Query("select a.id from Autor a where a.id = :id")
    public Autor findAutorById(@Param("id") int id);

    @Query("select a.nombre from Autor a where a.nombre like %:nombre")
    public List<Autor> findAutorsByNombre(@Param("nombre") String nombre);

    @Query("select a from Autor a where a.nombre like :nombre")
    public Autor deleteAutorByNombre(@Param("nombre") String nombre);

    @Query("select a from Autor a Where a.nombre like :nombre or a.id= :id")
    public Autor updateAutorByNombreOrId(@Param("nombre") String nombre, @Param("id") int id);

}
