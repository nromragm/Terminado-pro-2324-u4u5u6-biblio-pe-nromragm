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
    var id: UUID,
    val titulo: String,
    val autor: String,
    val anioPublicacion: Int,
    val tematica: String,
    var estado: EstadoLibro = EstadoLibro.DISPONIBLE
) {
    init {
        require(titulo.isNotBlank()) { "El titulo del libro no puede estar vacio" }
        require(autor.isNotBlank()) { "El autor del libro no puede estar vacio" }
        require(anioPublicacion in 1..2024) { "El año de publicación debe estar entre 1 y 2024" }
        require(tematica.isNotBlank()) { "La tematica del libro no puede estar vacia" }
        require(estado == EstadoLibro.DISPONIBLE || estado == EstadoLibro.PRESTADO) { "El estado del libro debe estar o disponible o prestado" }
    }
}