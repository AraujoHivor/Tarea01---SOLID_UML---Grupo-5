/**
 * DISEÑO DE SOFTWARE - Tarea01 SOLID UML
 * Tema: Sistema PetDayCare
 * Profesor: David Jurado
 * @author McDerian (Xavier Lopez M.)
 * Fecha: 01 nov 2025
 */
package com.petdaycare;

public interface Notificador {
    void enviar(String destino, String mensaje);
    String nombreCanal();
}
