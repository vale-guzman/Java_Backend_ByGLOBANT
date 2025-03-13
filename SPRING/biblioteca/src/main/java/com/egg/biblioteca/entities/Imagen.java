package com.egg.biblioteca.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Imagen {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String mime; //es el atributo que asigna el formato del archivo de la imagen.
    private String nombre;

    @Lob @Basic(fetch = FetchType.LAZY) //Lob: le avisa a String, que este atributo puede ser Grande
                                        //Basic: le indicamos cómo va a ser el tipo de carga.
                                        //Lazy: hace que se cargue este atributo Solo cuando lo pidamos, es decir,solo cuando hagamos un .get
    private byte[] contenido; //almacenar datos binarios, como archivos.

    public Imagen() {    }

    //Getters & Setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte[] getContenido() {
        return contenido;
    }

    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
    }
}
