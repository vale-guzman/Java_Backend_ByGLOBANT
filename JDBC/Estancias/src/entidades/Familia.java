package entidades;

public class Familia {
    private int idFamilia;
    private String nombreFamilia;
    private int edadMin;
    private int edadMax;
    private int cantHijos;
    private String email;
    private int idCasa;

    //Constructor sin parámetros
    public Familia() {
    }

    //Constructor con todos los pámetros
    public Familia(int idFamilia, String nombreFamilia, int edadMin, int edadMax, int cantHijos, String email, int idCasa) {
        this.idFamilia = idFamilia;
        this.nombreFamilia = nombreFamilia;
        this.edadMin = edadMin;
        this.edadMax = edadMax;
        this.cantHijos = cantHijos;
        this.email = email;
        this.idCasa = idCasa;
    }

    //Constructor con todos los parámetros excepto idFamilia
    public Familia(String nombreFamilia, int edadMin, int edadMax, int cantHijos, String email, int idCasa) {
        this.nombreFamilia = nombreFamilia;
        this.edadMin = edadMin;
        this.edadMax = edadMax;
        this.cantHijos = cantHijos;
        this.email = email;
        this.idCasa = idCasa;
    }

    //getters & setters
    public int getIdFamilia() {
        return idFamilia;
    }
    public void setIdFamilia(int idFamilia) {
        this.idFamilia = idFamilia;
    }
    public String getNombreFamilia() {
        return nombreFamilia;
    }
    public void setNombreFamilia(String nombreFamilia) {
        this.nombreFamilia = nombreFamilia;
    }
    public int getEdadMin() {
        return edadMin;
    }
    public void setEdadMin(int edadMin) {
        this.edadMin = edadMin;
    }
    public int getEdadMax() {
        return edadMax;
    }
    public void setEdadMax(int edadMax) {
        this.edadMax = edadMax;
    }
    public int getCantHijos() {
        return cantHijos;
    }
    public void setCantHijos(int cantHijos) {
        this.cantHijos = cantHijos;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getIdCasa() {
        return idCasa;
    }
    public void setIdCasa(int idCasa) {
        this.idCasa = idCasa;
    }

    @Override
    public String toString() {
        return "[" +
                "Familia:" + idFamilia +
                ", NombreFamilia:'" + nombreFamilia + '\'' +
                ", EdadMín:" + edadMin +
                ", EdadMáx:" + edadMax +
                ", Cant_Hijos:" + cantHijos +
                ", email:'" + email + '\'' +
                ", idCasa:" + idCasa +
                ']';
    }
}
