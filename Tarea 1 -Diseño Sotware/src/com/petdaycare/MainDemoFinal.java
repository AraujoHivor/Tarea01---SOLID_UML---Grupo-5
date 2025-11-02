/**
 * DESEÑO DE SOFTWARE - Tarea01 SOLID UML
 * Tema: Sistema PetDayCare
 * Profesora: David Jurado
 * @author McDerian (Xavier Lopez M.)
 * Fecha: 01 nov 2025
 */
package com.petdaycare;

import java.time.LocalDateTime;

public class MainDemoFinal {
    public static void main(String[] args) {
        Centro centro = new Centro("c1", "PetCenter Central", 20);
        Servicio paseos = new PaseoService("s1", "Paseo", 10.0);
        Servicio guarderia = new GuarderiaService("s2", "Guarderia", 25.0);
        centro.addServicio(paseos);
        centro.addServicio(guarderia);

        Notificador noti = new NotificadorEmail();
        Sistema sistema = new Sistema(centro, noti);

        Usuario usuario = new Usuario("u1", "Hivor Araujo", "hivor@example.com");
        Mascota mascota = new Mascota("m1", "Firulais", "Perro", "Labrador", 3, "Grande", "Ninguna");
        usuario.addMascota(mascota);

        LocalDateTime inicio = LocalDateTime.now().plusDays(2);
        LocalDateTime fin = inicio.plusHours(4);

        // Caso: solicitar reserva (secuencia 1)
        Reserva reserva = sistema.solicitarReservaServicio(usuario, mascota, paseos, inicio, fin);
        if (reserva == null) {
            System.out.println("No fue posible iniciar la reserva (compatibilidad o cupo)"); return;
        }
        System.out.println("Reserva iniciada id=" + reserva.getId() + ", estado=" + reserva.getEstado());

        // Asignar cuidador (simula alternativa)
        Cuidador cuidador = new Cuidador("cuid1", "Juan Cuidador", "cuidador@example.com", "CU1");
        sistema.asignarCuidadorYConfirmar(reserva, cuidador);

        // Procesar pago (secuencia 2)
        Pago pago = new PagoTarjeta("4111111111111111");
        boolean pagado = sistema.procesarYConfirmarPago(reserva, pago);
        System.out.println("Pago realizado? " + pagado + ", estado reserva=" + reserva.getEstado());

        // Generar incidente y gestionar (secuencia 3)
        GestorIncidentes gi = new GestorIncidentes();
        Incidente inc = new Incidente("i1", "Mascota con comportamiento agresivo", usuario.getEmail());
        gi.reportarIncidente(inc);
        gi.ingresarGestorIncidente();
        gi.solicitarMasDetalles(inc);
        gi.cargarDetallesAlGestor(inc, "Se requieren fotos y contacto"); 
        gi.analizarInformacion(inc);
        gi.contactarUsuario(inc, noti);
        gi.enviarRecordatorio(inc, noti);
        gi.activarCasoDeUso(inc);
        gi.resolverEquipoGeneral(inc);

        System.out.println("Estado final incidente: " + inc.getEstado());
    }
}
