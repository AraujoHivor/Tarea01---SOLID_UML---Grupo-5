package com.petdaycare;

public class Cuidador extends Usuario{
    private String cuidadorId;
    private boolean disponibile = true;

    public Cuidador(String id, String nombre, String email, String cuidador){
        super(id, nombre, email);
        this.cuidadorId = cuidadorId;
    }

    public boolean isDisponible(){ return disponibile;}
    public void setDisponible(boolean d){ this.disponibile = d;}
    public String getCuidadorId() { return cuidadorId;}

}
