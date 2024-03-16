package org.pebiblioteca

/**
 * Clase que gestiona el registro de prestamos
 */
class RegistroPrestamos {
    private val prestamosActuales: MutableList<Prestamo> = mutableListOf()
    private val historialPrestamos: MutableList<Prestamo> = mutableListOf()

    /**
     * Registra un prestamo de un libro a un usuario
     *
     * @param usuario Usuario que realiza el prestamo
     * @param libro Libro prestado
     */
    fun registrarPrestamo(usuario: Usuario, libro: Libro) {
        val prestamo = Prestamo(usuario, libro)
        prestamosActuales.add(prestamo)
        libro.cambiarEstado(EstadoLibro.PRESTADO)
        println("Prestamo registrado: ${libro.obtenerTitulo()} de ${usuario.nombre}")
    }

    /**
     * Registra la devolucion de un libro por parte de un usuario
     *
     * @param usuario Usuario que devuelve el libro
     * @param libro Libro devuelto
     */
    fun registrarDevolucion(usuario: Usuario, libro: Libro) {
        val prestamo = prestamosActuales.find { it.libro == libro && it.usuario == usuario }
        if (prestamo != null) {
            prestamosActuales.remove(prestamo)
            historialPrestamos.add(prestamo)
            libro.cambiarEstado(EstadoLibro.DISPONIBLE)
            println("Devolucion registrada: ${libro.obtenerTitulo()} de ${usuario.nombre}")
        } else {
            println("Error: No se encontro el prestamo")
        }
    }


    /**
     * Consulta el historial de prestamos de un libro
     *
     * @param libro Libro del cual se va a consultar el historial de prestamos
     * @return Lista de prestamos realizados sobre el libro
     */
    fun consultarHistorialPrestamosLibro(libro: Libro): List<Prestamo> {
        return historialPrestamos.filter { it.libro == libro }
    }

    /**
     * Consulta el historial de prestamos realizados por un usuario
     *
     * @param usuario Usuario del cual se va a consultar el historial de prestamos
     * @return Lista de prestamos realizados por el usuario
     */
    fun consultarHistorialPrestamosUsuario(usuario: Usuario): List<Prestamo> {
        return historialPrestamos.filter { it.usuario == usuario }
    }
}
