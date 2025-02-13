package com.egg.entidades;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table (name = "pago")
public class Pago {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private int idPago;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_pago")
    private Date fechaPago;

    @Column(name = "forma_pago")
    private String formaPago;

    @Column(name = "id_transaccion")
    private String idTransaccion;

    private float total;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente idCliente;

    //Constructor Vacío
    public Pago() {
    }

    //Getters & Setters
    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Cliente getIdCliente() {    return idCliente;    }
    public void setIdCliente(Cliente idCliente) {        this.idCliente = idCliente;    }
}
