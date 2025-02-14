package com.egg.entidades;

import jakarta.persistence.*;

@Entity
@Table (name = "gama_producto")
public class GamaProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_gama")
    private int idGama;

    @Column(name = "descripcion_texto", length = 255)
    private String descripcionTexto;

    @Column (name = "descripcion_html", length = 255)
    private String descripcionHtml;

    private String gama;

    private String imagen;

    //Constructor empty
    public GamaProducto() {    }

    //Setters & Getters
    public int getIdGama() {
        return idGama;
    }
    public void setIdGama(int idGama) {
        this.idGama = idGama;
    }
    public String getDescripcionTexto() {
        return descripcionTexto;
    }
    public void setDescripcionTexto(String descripcionTexto) {
        this.descripcionTexto = descripcionTexto;
    }
    public String getDescripcionHtml() {
        return descripcionHtml;
    }
    public void setDescripcionHtml(String descripcionHtml) {
        this.descripcionHtml = descripcionHtml;
    }
    public String getGama() {
        return gama;
    }
    public void setGama(String gama) {
        this.gama = gama;
    }
    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

}
