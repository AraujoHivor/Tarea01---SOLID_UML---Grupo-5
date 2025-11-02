package com.petdaycare;

public interface Pago {
    boolean procesar(double monto);
    String getMetodo();
    void marcarPagado();
}
