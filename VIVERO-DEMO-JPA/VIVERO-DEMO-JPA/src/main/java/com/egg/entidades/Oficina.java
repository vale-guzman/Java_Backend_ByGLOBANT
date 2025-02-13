package com.egg.entidades;

import jakarta.persistence.*;

@Entity
@Table (name="oficina")
public class Oficina {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_oficina")
    private int idOficina;
    @Column (name = "codigo_oficina")
    private String codOficina;
    private String city;
    private String pais;
    private String region;
    @Column(name = "codigo_postal")
    private String codPostal;
    private String phone;
}
