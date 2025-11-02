/**
 * DISEÑO DE SOFTWARE - Tarea01 SOLID UML
 * Tema: Sistema PetDayCare
 * Profesor: David Jurado
 * @author McDerian (Xavier Lopez M.)
 * Fecha: 01 nov 2025
 */

package com.petdaycare;

public class GuarderiaService extends ServicioBase {
    public GuarderiaService(String id, String nombre, double precioBase) {
        super(id, nombre, precioBase);
    }

    @Override
    public boolean esCompatibleCon(Mascota m) {
        String tam = m.getTamano().toLowerCase();
        return tam.equals("pequeño") || tam.equals("mediano");
    }
}
