package com.egg.bibliotecaAPI.repositories;

import com.egg.bibliotecaAPI.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, Long> {
}
