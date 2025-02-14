package com.egg.entidades;

import jakarta.persistence.*;

@Entity
@Table (name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_cliente")
    private int idCliente;

    @Column(name = "codigo_cliente")
    private int codCliente;

    @Column(name = "nombre_contacto")
    private String nombreContacto;

    @Column(name = "apellido_contacto")
    private String apellidoContacto;

    private String telefono;
    private String fax;
    private String ciudad;
    private String pais;

    @Column (name = "codigo_postal")
    private String cp;


    @Column (name = "id_empleado")
    private int idEmpleado;

    @Column (name = "limite_credito")
    private Double limiteCredito;

    @Column(name = "nombre_cliente")
    private String nombreCliente;

    //Constructor Vacío
    public Cliente() {
    }

    //Getters & Setters
    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public int getCodCliente() {
        return codCliente;
    }
    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }
    public String getNombreContacto() {
        return nombreContacto;
    }
    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }
    public String getApellidoContacto() {
        return apellidoContacto;
    }
    public void setApellidoContacto(String apellidoContacto) {
        this.apellidoContacto = apellidoContacto;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getFax() {
        return fax;
    }
    public void setFax(String fax) {
        this.fax = fax;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public String getCp() {
        return cp;
    }
    public void setCp(String cp) {
        this.cp = cp;
    }

    public int getIdEmpleado() {        return idEmpleado;    }
    public void setIdEmpleado(int idEmpleado) {        this.idEmpleado = idEmpleado;    }
    public double getLimiteCredito() {
        return limiteCredito;
    }
    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }
    public String getNombreCliente() {
        return nombreCliente;
    }
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
}
