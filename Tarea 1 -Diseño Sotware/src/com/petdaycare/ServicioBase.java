package com.petdaycare;

public abstract class ServicioBase implements Servicio {
    protected String id;
    protected String nombre;
    protected double precioBase;
    protected String horario = "00:00-23:59";

    public ServicioBase(String id, String nombre, double precioBase) {
        this.id = id;
        this.nombre = nombre;
        this.precioBase = precioBase;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecioBase() { return precioBase; }
    public void setHorario(String horario) { this.horario = horario; }
    public String getHorario() { return horario; }
}
