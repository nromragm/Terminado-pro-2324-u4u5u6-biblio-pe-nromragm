package org.pebiblioteca

import java.util.*

object UtilidadesBiblioteca {

    /**
     * Genera un UUID random
     *
     * @return El UUID generado
     */
    fun generarUUID(): UUID {
        val uuid = UUID.randomUUID()
        return uuid
    }

    /**
     * Muestra un mensaje por consola
     *
     * @param mensaje El mensaje a mostrar
     */
    fun mostrarMensaje(mensaje: String) {
        println(mensaje)
    }
}