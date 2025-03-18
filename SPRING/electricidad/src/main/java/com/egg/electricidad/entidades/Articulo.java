package com.egg.electricidad.entidades;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@NoArgsConstructor
@Data
@Entity
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name="nro_articulo", unique = true, nullable = false)
//  private static final AtomicInteger atomicInteger= new AtomicInteger(1);
    private Integer nroArticulo;

    private String nombre;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name="id_fabrica")
    private Fabrica fabrica;


}
