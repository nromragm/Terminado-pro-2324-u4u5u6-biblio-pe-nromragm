package org.pebiblioteca
import org.pebiblioteca.UtilidadesBiblioteca.generarUUID
import org.pebiblioteca.UtilidadesBiblioteca.mostrarMensaje
import java.util.UUID

class GestorBiblioteca(private val registroPrestamos: RegistroPrestamos) {

    //Catalogo de libros de la biblioteca
    val catalogo = mutableListOf<Libro>()

    /**
     * Agrega un libro al catalogo
     *
     * @param libro El libro a agregar
     */
    fun agregarLibro(libro: Libro) {
        val nuevoId = generarUUID()
        libro.cambiarId(nuevoId)
        catalogo.add(libro)
        mostrarMensaje("Libro: ${libro.obtenerTitulo()} agregado")
    }

    /**
     * Elimina un libro del catálogo de la biblioteca
     *
     * @param id El ID del libro a eliminar
     */

    fun eliminarLibro(id: UUID) {
        catalogo.removeAll { it.obtenerId() == id }
    }


    /**
     * Realiza el prestamo de un libro a un usuario
     *
     * @param usuario Usuario al que se le realizara el prestamo
     * @param libro Libro que se va a prestar
     */
    fun realizarPrestamo(usuario: Usuario, libro: Libro) {
        if (libro.obtenerEstado() == EstadoLibro.DISPONIBLE) {
            registroPrestamos.registrarPrestamo(usuario, libro)
            usuario.agregarLibroPrestado(libro)
        }
        else (println("El libro no esta Disponible"))
    }

    /**
     * Realiza la devolucion de un libro por parte de un usuario
     *
     * @param usuario Usuario que realiza la devolucion
     * @param libro Libro que se devuelve
     */

    fun realizarDevolucion(usuario: Usuario, libro: Libro) {
        if (libro.obtenerEstado() == EstadoLibro.PRESTADO){
            registroPrestamos.registrarDevolucion(usuario, libro)
            usuario.quitarLibroPrestado(libro)
        }
        else (println("El libro no esta Prestado"))
    }


    /**
     * Muestra el estado de todos los libros en la biblioteca.
     */
    fun mostrarEstadoLibros() {
        println("Estado de los libros:")
        catalogo.forEach { println("Libro(Id: ${it.obtenerId()}, Titulo: ${it.obtenerTitulo()}, Estadp: ${it.obtenerEstado()})")  }
    }

    /**
     * Consulta la disponibilidad de un libro en la biblioteca
     *
     * @param idLibro El ID del libro a consultar
     */
    fun consultarDisponibilidad(idLibro: UUID) {
        val libro = catalogo.find { it.obtenerId() == idLibro }

        if (libro != null) {
            val disponibilidad = if (libro.obtenerEstado() == EstadoLibro.DISPONIBLE) "disponible" else "prestado"
            println("El libro: ${libro.obtenerTitulo()} esta $disponibilidad.")
        } else {
            println("Error: El libro no se encuentra en el catalogo.")
        }
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
    fun listarLibrosDisponibles(): List<Libro> = catalogo.filter { it.obtenerEstado() == EstadoLibro.DISPONIBLE }

    /**
     * Devuelve una lista con los libros prestados
     *
     * @return La lista de libros prestados
     */
    fun listarLibrosPrestados(): List<Libro> = catalogo.filter { it.obtenerEstado() == EstadoLibro.PRESTADO }
}
