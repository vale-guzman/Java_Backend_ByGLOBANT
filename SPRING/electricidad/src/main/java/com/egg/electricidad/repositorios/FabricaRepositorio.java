package com.egg.electricidad.repositorios;

import com.egg.electricidad.entidades.Fabrica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FabricaRepositorio extends JpaRepository<Fabrica, UUID> {
}
