package org.pebiblioteca
import org.pebiblioteca.UtilidadesBiblioteca.generarUUID
import java.util.UUID
class GestorBiblioteca {
    //Catalogo de libros de la biblioteca
    val catalogo = mutableListOf<Libro>()

    //Registro de prestamos realizados
    private val registroPrestamos = mutableListOf<Pair<UUID, String>>()

    /**
     * Agrega un libro al catalogo
     *
     * @param libro El libro a agregar
     */
    fun agregarLibro(libro: Libro) {
        val nuevoId = generarUUID()
        libro.id = nuevoId
        catalogo.add(libro)
        println("Libro: ${libro.titulo} agregado")
    }


    /**
     * Elimina un libro del catálogo de la biblioteca
     *
     * @param id El ID del libro a eliminar
     */
    fun eliminarLibro(id: UUID) {
        catalogo.removeAll { it.id == id }
    }


    /**
     * Registra un prestamo de libro en la biblioteca
     *
     * @param idLibro El ID del libro que se va a prestar
     */
    fun registrarPrestamo(idLibro: UUID) {
        val libro = catalogo.find { it.id == idLibro }
        if (libro != null && libro.estado == EstadoLibro.DISPONIBLE) {
            libro.estado = EstadoLibro.PRESTADO
            registroPrestamos.add(Pair(idLibro, "prestado")) // Añadir el prestamo al registro de prestamo
            println("Libro prestado correctamente")
        } else {
            println("Error: El libro no esta disponible.")
        }
    }


    /**
     * Devuelve un libro prestado, cambiando su estado a DISPONIBLE
     *
     * @param idLibro El ID del libro que se devuelve
     */
    fun devolverLibro(idLibro: UUID) {
        val libro = catalogo.find { it.id == idLibro }
        if (libro != null && libro.estado == EstadoLibro.PRESTADO) {
            libro.estado = EstadoLibro.DISPONIBLE
            println("Libro devuelto correctamente")
        } else {
            println("Error: El libro no esta prestado.")
        }
    }


    /**
     * Consulta la disponibilidad de un libro en la biblioteca
     *
     * @param idLibro El ID del libro a consultar
     */
    fun consultarDisponibilidad(idLibro: UUID) {
        val libro = catalogo.find { it.id == idLibro }
        if (libro != null) {
            val disponibilidad = if (libro.estado == EstadoLibro.DISPONIBLE) "disponible" else "prestado"
            println("El libro ${libro.titulo} esta $disponibilidad.")
        } else {
            println("Error: El libro no se encuentra en el catálogo.")
        }
    }


    /**
     * Muestra el estado de todos los libros en la biblioteca.
     */
    fun mostrarEstadoLibros() {
        println("Estado de los libros:")
        catalogo.forEach { println("Libro(Id: ${it.id}, Titulo: ${it.titulo}, Estado: ${it.estado})") }
    }


    /**
     * Devuelve una lista con todos los libros en el catalogo
     *
     * @return La lista de todos los librod
     */
    fun listarTodosLosLibros(): List<Libro> = catalogo

    /**
     * Devuelve una lista con los libros disponibles
     *
     * @return La lista de libros disponibles
     */
    fun listarLibrosDisponibles(): List<Libro> = catalogo.filter { it.estado == EstadoLibro.DISPONIBLE }

    /**
     * Devuelve una lista con los libros prestados
     *
     * @return La lista de libros prestados
     */
    fun listarLibrosPrestados(): List<Libro> = catalogo.filter { it.estado == EstadoLibro.PRESTADO }
}