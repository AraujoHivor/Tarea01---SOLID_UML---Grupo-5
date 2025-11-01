package com.petdaycare;

public interface Servicio {
    String getId();
    String getNombre();
    double getPrecioBase();
    boolean esCompatibleCon(Mascota m);
    void setHorario(String horario);
    String getHorario();
}
