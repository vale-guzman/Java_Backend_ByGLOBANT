package entidades;

import java.util.Date;

//Esta clase refiere al registro de una estadía realizada en una Casa por un Cliente
public class Estancia {
    private int idEstancia;
    private int idCliente;
    private int idCasa;
    private String nombreCliente;
    private Date fechaDesde;
    private Date fechaHasta;

    //Constructor sin parámetros
    public Estancia() {
    }

    //Constructor con todos los pámetros
    public Estancia(int idEstancia, int idCliente, int idCasa, String nombreCliente, Date fechaDesde, Date fechaHasta) {
        this.idEstancia = idEstancia;
        this.idCliente = idCliente;
        this.idCasa = idCasa;
        this.nombreCliente = nombreCliente;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
    }

    //getters & setters
    public int getIdEstancia() {
        return idEstancia;
    }

    public void setIdEstancia(int idEstancia) {
        this.idEstancia = idEstancia;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdCasa() {
        return idCasa;
    }

    public void setIdCasa(int idCasa) {
        this.idCasa = idCasa;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public String toString() {
        return "[" +
                "Nro_Estancia:" + idEstancia +
                ", Nro_Cliente:'" + idCliente +
                ", Huesped:'" + nombreCliente +
                ", Nro_Casa:'" + idCasa +
                "|Fecha_Desde:'" + fechaDesde +
                "--> Hasta:'" + fechaHasta +'\'' +
                ']';
    }
}

