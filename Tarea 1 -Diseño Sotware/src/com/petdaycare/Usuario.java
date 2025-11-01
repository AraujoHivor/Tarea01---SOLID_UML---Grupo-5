package com.petdaycare;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    protected String id;
    protected String nombre;
    protected String email;
    protected List<Mascota> mascotas = new ArrayList<>();

    public Usuario(String id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public void addMascota(Mascota m) {
        mascotas.add(m);
    }

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
}
