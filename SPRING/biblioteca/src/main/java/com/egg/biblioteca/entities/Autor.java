package com.egg.biblioteca.entities;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table (name="autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    //@GenericGenerator(name = "uuid", strategy = "uuid2") está deprecado.
    private UUID id;

    String nombre;

    public Autor() {    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
