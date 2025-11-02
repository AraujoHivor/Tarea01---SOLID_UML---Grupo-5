package com.petdaycare;

public class NotificadorEmail implements Notificador {
    @Override
    public void enviar(String destino, String mensaje) {
        System.out.println("[EMAIL to=" + destino + "] " + mensaje);
    }

    @Override
    public String nombreCanal() { return "Email"; }
}
