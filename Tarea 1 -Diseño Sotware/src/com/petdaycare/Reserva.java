package com.petdaycare;

import java.time.LocalDateTime;
import java.util.UUID;

public class Reserva {
    public enum Estado { BLOQUEADO, PENDIENTE, CONFIRMADA, CANCELADA }

    private String id;
    private Usuario propietario;
    private Mascota mascota;
    private Servicio servicio;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private Pago pago;
    private Estado estado;
    private Cuidador cuidadorAsignado;

    public Reserva(Usuario propietario, Mascota mascota, Servicio servicio, LocalDateTime inicio, LocalDateTime fin) {
        this.id = UUID.randomUUID().toString();
        this.propietario = propietario;
        this.mascota = mascota;
        this.servicio = servicio;
        this.fechaInicio = inicio;
        this.fechaFin = fin;
        this.estado = Estado.BLOQUEADO;
    }

    public String getId() { return id; }
    public Usuario getPropietario() { return propietario; }
    public Mascota getMascota() { return mascota; }
    public Servicio getServicio() { return servicio; }
    public void setPago(Pago pago) { this.pago = pago; }
    public Pago getPago() { return pago; }
    public void setEstado(Estado e) { this.estado = e; }
    public Estado getEstado() { return estado; }
    public void asignarCuidador(Cuidador c) { this.cuidadorAsignado = c; }
    public Cuidador getCuidadorAsignado() { return cuidadorAsignado; }

    public double calcularCosto() {
        return servicio.getPrecioBase();
    }
}
