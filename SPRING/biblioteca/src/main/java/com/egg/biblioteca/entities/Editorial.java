package com.egg.biblioteca.entities;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table (name="editoriales")
public class Editorial {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    //@GenericGenerator(name = "uuid", strategy = "uuid2") está deprecado.
    private UUID id;

    private String nombre;

    public Editorial() {    }

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
