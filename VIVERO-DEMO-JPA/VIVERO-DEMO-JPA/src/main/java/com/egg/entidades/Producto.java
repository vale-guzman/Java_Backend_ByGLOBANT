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

    //Constructor vacío
    public Producto() {
    }

    //Setters & Getters
    public int getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    public int getCantStock() {
        return cantStock;
    }
    public void setCantStock(int cantStock) {
        this.cantStock = cantStock;
    }
    public String getCodProducto() {
        return codProducto;
    }
    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDimensiones() {
        return dimensiones;
    }
    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public float getPrecioProveedor() {
        return precioProveedor;
    }
    public void setPrecioProveedor(float precioProveedor) {
        this.precioProveedor = precioProveedor;
    }
    public float getPrecioVenta() {
        return precioVenta;
    }
    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }
    public GamaProducto getGamaProducto() {
        return gamaProducto;
    }
    public void setGamaProducto(GamaProducto gamaProducto) {
        this.gamaProducto = gamaProducto;
    }
}
