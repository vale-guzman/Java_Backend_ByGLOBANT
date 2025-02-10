package entidades;

import java.util.Date;

public class Casa {
    private int idCasa;
    private String calle;
    private int nro;
    private String cp;
    private String ciudad;
    private String pais;
    private Date fechaDesde;
    private Date fechaHasta;
    private int timeMin;
    private int timeMax;
    private float priceRoom;
    private String typeVivienda;

    //Constructor sin parámetros
    public Casa() {    }

    //Constructor con todos los pámetros
    public Casa(int idCasa, String calle, int nro, String cp, String ciudad, String pais, Date fechaDesde, Date fechaHasta, int timeMin, int timeMax, float priceRoom, String typeVivienda) {
        this.idCasa = idCasa;
        this.calle = calle;
        this.nro = nro;
        this.cp = cp;
        this.ciudad = ciudad;
        this.pais = pais;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.timeMin = timeMin;
        this.timeMax = timeMax;
        this.priceRoom = priceRoom;
        this.typeVivienda = typeVivienda;
    }

    //getters & setters
    public int getIdCasa() {
        return idCasa;
    }

    public String getCalle() {
        return calle;
    }

    public int getNro() {
        return nro;
    }

    public String getCp() {
        return cp;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getPais() {
        return pais;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public int getTimeMin() {
        return timeMin;
    }

    public int getTimeMax() {
        return timeMax;
    }

    public float getPriceRoom() {
        return priceRoom;
    }

    public String getTypeVivienda() {
        return typeVivienda;
    }

   public void setIdCasa (int idCasa) {
        this.idCasa=idCasa;
   }
    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public void setTimeMin(int timeMin) {
        this.timeMin = timeMin;
    }

    public void setTimeMax(int timeMax) {
        this.timeMax = timeMax;
    }

    public void setPriceRoom(float priceRoom) {
        this.priceRoom = priceRoom;
    }

    public void setTypeVivienda(String typeVivienda) {
        this.typeVivienda = typeVivienda;
    }

    @Override
    public String toString() {
        return "[" +
                "Casa:" + idCasa +
                ", Dirección:'" + calle + " " + nro + '\'' +
                ", CP:'" + cp + '\'' +
                ", Ciudad:'" + ciudad + "-" + pais + '\'' +
                ",|Alquiler_Desde:" + fechaDesde +
                "--> Hasta:" + fechaHasta +
                " |Tiempo_Mínimo:" + timeMin +
                ", Tiempo_Máximo:" + timeMax +
                ", precio_Habitación:" +'$'+ priceRoom +
                ", Tipo_De_Casa:'" + typeVivienda + '\'' +
                ']';
    }
}
