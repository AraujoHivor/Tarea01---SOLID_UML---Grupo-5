package com.petdaycare;

import java.util.ArrayList;
import java.util.List;

public class GestorIncidentes {

    private List<Incidente> incidentes = new ArrayList<>();

    public void ingresarGestorIncidente() {
        System.out.println("[GestorIncidentes] Acceso al módulo de incidentes");
    }

    public void reportarIncidente(Incidente inc) {
        incidentes.add(inc);
    }

    public List<Incidente> listarIncidentes() {
        return new ArrayList<>(incidentes);
    }

    public Incidente seleccionarIncidente(String id) {
        return incidentes.stream().filter(i -> i.getId().equals(id)).findFirst().orElse(null);
    }

    public void solicitarMasDetalles(Incidente i) {
        System.out.println("Solicitando más detalles para incidente " + i.getId());
    }

    public void cargarDetallesAlGestor(Incidente i, String detalles) {
        i.setDescripcion(i.getDescripcion() + " | detalles: " + detalles);
    }

    public void analizarInformacion(Incidente i) {
        System.out.println("Analizando incidente: " + i.getId());
    }

    public void contactarUsuario(Incidente i, Notificador notificador) {
        notificador.enviar(i.getReportador(), "Se requiere información adicional para el incidente " + i.getId());
    }

    public void enviarRecordatorio(Incidente i, Notificador notificador) {
        notificador.enviar(i.getReportador(), "Recordatorio: por favor responda sobre incidente " + i.getId());
    }

    public void cambiarEstadoIncidente(Incidente i, String estado) {
        i.setEstado(estado);
    }

    public void activarCasoDeUso(Incidente i) {
        System.out.println("Activando caso de uso para incidente: " + i.getId());
    }

    public void resolverEquipoGeneral(Incidente i) {
        System.out.println("Equipo general resolviendo incidente: " + i.getId());
        i.setEstado("Resuelto por Equipo General");
    }


}
