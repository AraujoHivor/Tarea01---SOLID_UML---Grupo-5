package com.petdaycare;

public class ProcesadorPago {
    public boolean procesarPago(Pago pago, double monto) {
        return pago.procesar(monto);
    }
}
