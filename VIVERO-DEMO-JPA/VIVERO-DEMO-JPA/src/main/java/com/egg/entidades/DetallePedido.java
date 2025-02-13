package com.egg.entidades;

import jakarta.persistence.*;

@Entity     //Se declara como Entidad
@Table(name = "detalle_pedido") //Declaro cómo quiero que se llame
public class DetallePedido {
    @Id //Genero y declaro el id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_pedido")
    private int idDetallePedido;
    private int cantidad;

    @Column(name = "numero_linea")
    private int numeroLinea;

    @Column(name = "precio_unidad")
    private float precioUnidad;

    @ManyToOne //Defino el tipo de relación. Muchos Detalles están relaciones a un mismo PRODUCTO.
    @JoinColumn(name = "id_producto") //la relación con PRODUCTO es através de este atributo.
    private Producto producto;

    @ManyToOne //Defino el tipo de relación. Muchos Detalles están relaciones a un mismo PEDIDO.
    @JoinColumn(name = "id_pedido") //la relación con PEDIDO es através de este atributo.
    private Pedido pedido;

    //Constructor vacío
    public DetallePedido() {
    }

    //Getters & Setters
    public int getIdDetallePedido() {
        return idDetallePedido;
    }
    public void setIdDetallePedido(int idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public int getNumeroLinea() {
        return numeroLinea;
    }
    public void setNumeroLinea(int numeroLinea) {
        this.numeroLinea = numeroLinea;
    }
    public float getPrecioUnidad() {
        return precioUnidad;
    }
    public void setPrecioUnidad(float precioUnidad) {
        this.precioUnidad = precioUnidad;
    }
    public Producto getProducto() {
        return producto;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public Pedido getPedido() {
        return pedido;
    }
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
