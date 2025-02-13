package com.egg.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_empleado")
    private int idEmpleado;

    @Column (name = "codigo_empleado")
    private String codEmpleado;

    private String nombre;
    private String apellido;
    private String extension;
    private String email;

    @OneToOne
    @JoinColumn (name = "id_oficina")
    private Oficina idOficina;

    @OneToOne
    @JoinColumn(name="id_empleado")
    private Empleado idJefe;

    private String puesto;

    //Constructor Vacío
    public Empleado() {
    }

    //Getters & Setters


    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(String codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Oficina getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(Oficina idOficina) {
        this.idOficina = idOficina;
    }

    public Empleado getIdJefe() {
        return idJefe;
    }

    public void setIdJefe(Empleado idJefe) {
        this.idJefe = idJefe;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
}
