package com.petdaycare;

public class PaseoService extends ServicioBase {
    public PaseoService(String id, String nombre, double precioBase) {
        super(id, nombre, precioBase);
    }

    @Override
    public boolean esCompatibleCon(Mascota m) {
        String especie = m.getEspecie().toLowerCase();
        return especie.equals("perro") || especie.equals("gato");
    }
}
