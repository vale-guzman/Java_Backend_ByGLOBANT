package com.egg.entidades;

import jakarta.persistence.*;

@Entity
@Table (name= "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int idProducto;

    @Column(name = "cantidad_en_stock")
    private int cantStock;

    @Column(name = "codigo_producto")
    private String codProducto;
    private String descripcion;
    private String dimensiones;
    private String nombre;
    @Column(name = "precio_proveedor")
    private float precioProveedor;
    @Column(name = "precio_venta")
    private float precioVenta;
    @ManyToOne
    @JoinColumn(name = "id_gama")
    private GamaProducto gamaProducto;
}
