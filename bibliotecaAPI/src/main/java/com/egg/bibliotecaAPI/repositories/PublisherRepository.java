package com.egg.bibliotecaAPI.repositories;

import com.egg.bibliotecaAPI.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PublisherRepository extends JpaRepository<Publisher, UUID> {
}
