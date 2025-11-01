package com.petdaycare;

public class VerificadorDisponibilidad {
    private Centro centro;

    public VerificadorDisponibilidad(Centro centro) {
        this.centro = centro;
    }

    public boolean verificarCupoAfiliado(Servicio servicio) {
        // Lógica simplificada: si el centro ofrece el servicio, asumimos cupo.
        return centro.getServicios().stream().anyMatch(s -> s.getId().equals(servicio.getId()));
    }

    public boolean esCompatibleConServicio(Servicio servicio, Mascota mascota) {
        return servicio.esCompatibleCon(mascota);
    }
}
