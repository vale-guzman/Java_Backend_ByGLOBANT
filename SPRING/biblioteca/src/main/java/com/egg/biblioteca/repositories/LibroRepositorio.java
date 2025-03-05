package com.egg.biblioteca.repositories;

import com.egg.biblioteca.entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LibroRepositorio extends JpaRepository<Libro,Long> {
    @Query("SELECT l FROM Libro l WHERE l.isbn = :isbn")
    public Libro findLibroByIsbn(@Param("isbn") Long isbn);

    @Query("SELECT l FROM Libro l WHERE l.titulo like :titulo")
    public Libro findByLibroPorTitulo(@Param("titulo") String titulo);

    @Query ("select l from Libro l where l.autor.nombre= :nombre")
    public List<Libro> findByLibroPorAutor(@Param("nombre") String nombre);
 }
