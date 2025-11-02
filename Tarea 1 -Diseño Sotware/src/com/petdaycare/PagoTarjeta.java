package com.petdaycare;

public class PagoTarjeta implements Pago {
    private String tarjetaNumero;
    private boolean pagado = false;

    public PagoTarjeta(String tarjetaNumero) {
        this.tarjetaNumero = tarjetaNumero;
    }

    @Override
    public boolean procesar(double monto) {
        // Simula procesamiento simple
        if (tarjetaNumero == null || tarjetaNumero.isEmpty() || monto <= 0) return false;
        pagado = true;
        return true;
    }

    @Override
    public String getMetodo() { return "Tarjeta"; }

    @Override
    public void marcarPagado() { this.pagado = true; }
}
