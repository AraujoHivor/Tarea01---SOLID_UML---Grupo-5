package com.petdaycare;

public class Incidente {
    private String id;
    private String descripcion;
    private String estado;
    private String reportador; //email of the reporter

    public Incidente(String id, String descripcion, String reportador){
        this.id = id;
        this.descripcion = descripcion;
        this.reportador = reportador;
        this.estado = "Pendiente";
    }

    public String getId() {return id;}
    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
    public String getEstado() {return estado;}
    public void setEstado(String estado) {this.estado = estado;}
    public String getReportador() {return reportador;}

}
