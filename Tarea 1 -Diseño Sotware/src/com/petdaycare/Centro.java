package com.petdaycare;

import java.util.ArrayList;
import java.util.List;

public class Centro {
    private String id;
    private String nombre;
    private List<Servicio> servicios = new ArrayList<>();
    private List<Cuidador> cuidadores = new ArrayList<>();
    private int capacidadTotal;

    public Centro(String id, String nombre, int capacidadTotal){
        this.id = id;
        this.nombre = nombre;
        this.capacidadTotal = capacidadTotal;
    }

    public void addServicio(Servicio s){ servicios.add(s);}
    public void addCuidador(Cuidador c){ cuidadores.add(c);}
    public List<Servicio> getServicios() { return servicios;}
    public List<Cuidador> getCuidadores() { return cuidadores; }

    public Servicio getServicioById(String id) {
        return servicios.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }


}
