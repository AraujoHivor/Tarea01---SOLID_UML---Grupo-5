package com.petdaycare;

public class Mascota {
    private String id;
    private String nombre;
    private String especie;
    private String raza;
    private int edad;
    private String tamano;
    private String necesidadesEspeciales;

    public Mascota(String id, String nombre, String especie, String raza, int edad, String tamano, String necesidadesEspeciales) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.tamano = tamano;
        this.necesidadesEspeciales = necesidadesEspeciales;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEspecie() { return especie; }
    public String getTamano() { return tamano; }
    public String getNecesidadesEspeciales() { return necesidadesEspeciales; }
}
