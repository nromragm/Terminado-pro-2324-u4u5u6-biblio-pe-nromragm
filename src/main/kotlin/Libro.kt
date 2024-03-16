package org.pebiblioteca
import java.util.UUID

/**
 * Representa un libro en la biblioteca
 *
 * @property id El ID unico del libro
 * @property titulo El titulo del libro
 * @property autor El autor del libro
 * @property anioPublicacion El año de publicacion del libro
 * @property tematica La tematica del libro
 * @property estado El estado del libro (por defecto DISPONIBLE)
 */
data class Libro(
    val id: UUID,
    val titulo: String,
    val autor: String,
    val anioPublicacion: Int,
    val tematica: String,
    var estado: EstadoLibro = EstadoLibro.DISPONIBLE
)