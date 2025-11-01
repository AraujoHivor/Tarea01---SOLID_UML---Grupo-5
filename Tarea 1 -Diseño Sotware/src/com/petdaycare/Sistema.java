package com.petdaycare;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/* Controller that implements use-case flows from the sequence diagrams.
   Responsibilities moved from a single manager into a controller that coordinates
   VerificadorDisponibilidad, BloqueadorCupos, ProcesadorPago and Notificador.
   This mirrors your UML which spreads responsibilities among these collaborators. */
public class Sistema {
    private Centro centro;
    private VerificadorDisponibilidad verificador;
    private BloqueadorCupos bloqueador;
    private ProcesadorPago procesadorPago;
    private Notificador notificador;
    private List<Reserva> reservas = new ArrayList<>();

    public Sistema(Centro centro, Notificador notificador) {
        this.centro = centro;
        this.verificador = new VerificadorDisponibilidad(centro);
        this.bloqueador = new BloqueadorCupos();
        this.procesadorPago = new ProcesadorPago();
        this.notificador = notificador;
    }

    public List<Servicio> consultarReservasDisponibles() {
        return centro.getServicios();
    }

    public Reserva solicitarReservaServicio(Usuario usuario, Mascota mascota, Servicio servicio, LocalDateTime inicio, LocalDateTime fin) {
        // verifica compatibilidad
        if (!verificador.esCompatibleConServicio(servicio, mascota)) {
            System.out.println("Servicio no compatible con la mascota");
            return null;
        }
        // verifica cupo
        if (!verificador.verificarCupoAfiliado(servicio)) {
            System.out.println("No hay cupo en el centro para este servicio");
            return null;
        }
        // crear reserva y bloquear cupo
        Reserva reserva = new Reserva(usuario, mascota, servicio, inicio, fin);
        bloqueador.bloquear(reserva.getId());
        reservas.add(reserva);
        notificador.enviar(usuario.getEmail(), "Se ha bloqueado temporalmente su reserva: " + reserva.getId());
        return reserva;
    }

    public boolean asignarCuidadorYConfirmar(Reserva reserva, Cuidador cuidador) {
        if (reserva == null) return false;
        reserva.asignarCuidador(cuidador);
        reserva.setEstado(Reserva.Estado.PENDIENTE);
        notificador.enviar(reserva.getPropietario().getEmail(), "Se asignó cuidador: " + cuidador.getNombre());
        return true;
    }

    public boolean procesarYConfirmarPago(Reserva reserva, Pago pago) {
        double monto = reserva.calcularCosto();
        boolean ok = procesadorPago.procesarPago(pago, monto);
        if (ok) {
            pago.marcarPagado();
            reserva.setPago(pago);
            reserva.setEstado(Reserva.Estado.CONFIRMADA);
            bloqueador.liberar(reserva.getId());
            notificador.enviar(reserva.getPropietario().getEmail(), "Pago recibido. Reserva confirmada: " + reserva.getId());
            return true;
        } else {
            reserva.setEstado(Reserva.Estado.CANCELADA);
            bloqueador.liberar(reserva.getId());
            notificador.enviar(reserva.getPropietario().getEmail(), "Pago fallido para reserva: " + reserva.getId());
            return false;
        }
    }

    public void cancelarReserva(Reserva reserva, String motivo) {
        if (reserva == null) return;
        reserva.setEstado(Reserva.Estado.CANCELADA);
        bloqueador.liberar(reserva.getId());
        notificador.enviar(reserva.getPropietario().getEmail(), "Reserva cancelada: " + reserva.getId() + ". Motivo: " + motivo);
    }

    public void liberarBloqueo(Reserva reserva) {
        if (reserva == null) return;
        bloqueador.liberar(reserva.getId());
    }

    public List<Reserva> listarReservasUsuario(Usuario u) {
        List<Reserva> out = new ArrayList<>();
        for (Reserva r : reservas) if (r.getPropietario().getId().equals(u.getId())) out.add(r);
        return out;
    }
}
