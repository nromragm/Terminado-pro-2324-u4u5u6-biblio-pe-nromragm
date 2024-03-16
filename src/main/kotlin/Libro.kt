package org.pebiblioteca
import java.util.UUID

/**
 * Representa un libro en la biblioteca
 *
 * @property id Identificador unico del libro
 * @property titulo Titulo del libro
 * @property autor Autor del libro
 * @property anioPublicacion Año de publicacion del libro
 * @property tematica Tematica del libro
 * @property estado Estado del libro (por defecto estara DISPONIBLE)
 * @throws IllegalArgumentException Si el titulo, autor, año de publicacion o tematica estan en blanco, o si el estado no es DISPONIBLE o PRESTADO
 */
class Libro(
    private var id: UUID,
    private val titulo: String,
    private val autor: String,
    private val anioPublicacion: Int,
    private val tematica: String,
    private var estado: EstadoLibro = EstadoLibro.DISPONIBLE
) {

    init {
        require(titulo.isNotBlank()) { "El titulo del libro no puede estar vacio" }
        require(autor.isNotBlank()) { "El autor del libro no puede estar vacio" }
        require(anioPublicacion in 1..2024) { "El año de publicacion debe estar entre 1 y 2024" }
        require(tematica.isNotBlank()) { "La tematica del libro no puede estar vacia" }
        require(estado == EstadoLibro.DISPONIBLE || estado == EstadoLibro.PRESTADO) { "El estado del libro debe ser DISPONIBLE o PRESTADO" }
    }

    /**
     * Obtiene el ID del libro
     */
    fun obtenerId() = id

    /**
     * Obtiene el estado del libro
     */
    fun obtenerEstado() = estado

    /**
     * Obtiene el titulo del libro
     */
    fun obtenerTitulo() = titulo

    /**
     * Obtiene el autor del libro
     */
    fun obtenerAutor() = autor

    /**
     * Obtiene el año de publicacion del libro
     */
    fun obtenerAnioPublicacion() = anioPublicacion

    /**
     * Obtiene la tematica del libro
     */
    fun obtenerTematica() = tematica

    /**
     * Cambia el estado del libro
     *
     * @param nuevoEstado Nuevo estado del libro
     */
    fun cambiarEstado(nuevoEstado: EstadoLibro) {
        estado = nuevoEstado
    }

    /**
     * Cambia el ID del libro
     *
     * @param nuevoId Nuevo ID
     */
    fun cambiarId(nuevoId: UUID) {
        id = nuevoId
    }
}
