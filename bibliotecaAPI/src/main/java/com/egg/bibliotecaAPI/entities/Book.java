package com.egg.bibliotecaAPI.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="books")
public class Book {
    @Id
    @Column(unique = true)
    private long isbn;

    private String titulo;
    private int ejemplares;
    private boolean activo=true;

    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Author autor;

    @ManyToOne
    @JoinColumn(name = "id_editorial")
    private Publisher editorial;
}
