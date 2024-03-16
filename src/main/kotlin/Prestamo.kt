package org.pebiblioteca

/**
 * Representa un prestamo de un libro a un usuario
 *
 * @property usuario Usuario que realiza el prestamo
 * @property libro Libro prestado
 */
data class Prestamo(val usuario: Usuario, val libro: Libro)
