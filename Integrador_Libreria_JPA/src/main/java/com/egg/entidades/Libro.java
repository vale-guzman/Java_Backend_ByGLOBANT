package com.egg.entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name="libros")
public class Libro {

    @Id
    private Long isbn;

    private String titulo;
    private int anio;
    private int ejemplares;
    private boolean alta;

    @OneToMany //Defino el tipo de relación. Muchos Libros están relaciones a un mismo AUTOR.
    @JoinColumn(name = "id_autor") //la relación con AUTOR es através de este atributo.
    private List<Autor> autores;

    @OneToMany //Defino el tipo de relación. Muchos Libros están relaciones a un mismo EDITORIAL.
    @JoinColumn(name = "id_editorial") //la relación con EDITORIAL es através de este atributo.
    private List<Editorial> editoriales;

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

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public List<Editorial> getEditoriales() {
        return editoriales;
    }

    public void setEditoriales(List<Editorial> editoriales) {
        this.editoriales = editoriales;
    }
}
