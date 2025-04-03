package com.egg.bibliotecaAPI.repositories;

import com.egg.bibliotecaAPI.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> {
}
