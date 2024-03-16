package org.pebiblioteca

import java.util.UUID

/**
 * Clase que representa a un usuario
 *
 * @property id Id del usuario
 * @property nombre Nombre del usuario
 */
class Usuario(val id: UUID, val nombre: String) {
    private val librosPrestados = mutableListOf<Libro>()

    fun agregarLibroPrestado(libro: Libro) {
        librosPrestados.add(libro)
    }

    fun quitarLibroPrestado(libro: Libro) {
        librosPrestados.remove(libro)
    }

    fun obtenerLibrosPrestados(): List<Libro> {
        return librosPrestados.toList()
    }
}