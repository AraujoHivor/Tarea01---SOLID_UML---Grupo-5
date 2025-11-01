package com.petdaycare;

public class AdministradorCentro extends Usuario{
    private Centro centro;

    public AdministradorCentro(String id, String nombre, String email, Centro centro){
        super(id, nombre, email);
        this.centro = centro;
    }

    public Centro getCentro(){ return centro;}

    public void ingresarGestorIncidente(GestorIncidentes gestor){
        // muestra lista de incidentes en la interfaz del adminsitrador (simulado)
        System.out.println("[Admin] Accediendo al gestor de incidentes para centro: " + centro.getNombre());
    }




}
