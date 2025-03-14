package com.egg.biblioteca.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="libros")
public class Libro {

    @Id
    @Column(unique = true)
    private long isbn;

    private String titulo;
    private int ejemplares;

    //@Temporal (TemporalType.DATE)
    private Date alta;

    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "id_editorial")
    private Editorial editorial;
}
