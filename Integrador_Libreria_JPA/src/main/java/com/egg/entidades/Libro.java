package com.egg.entidades;

import jakarta.persistence.*;

@Entity
@Table (name="libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long isbn;

    private String titulo;
    private int anio;
    private int ejemplares;
    private boolean alta;

    @ManyToOne //Defino el tipo de relación. Muchos Libros están relaciones a un mismo AUTOR.
    @JoinColumn(name = "id_autor") //la relación con AUTOR es através de este atributo.
    private Autor autor;

    @ManyToOne //Defino el tipo de relación. Muchos Libros están relaciones a un mismo EDITORIAL.
    @JoinColumn(name = "id_editorial") //la relación con EDITORIAL es através de este atributo.
    private Editorial editorial;

    public Libro() {   }

    //Getters & Setters

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(int ejemplares) {
        this.ejemplares = ejemplares;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }
}
