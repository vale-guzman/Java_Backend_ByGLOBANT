package com.egg.biblioteca.repositories;

import com.egg.biblioteca.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, UUID>{

    @Query("SELECT u FROM Usuario u WHERE u.email like :email")
    public Usuario findByEmail(@Param("email") String email);
}
