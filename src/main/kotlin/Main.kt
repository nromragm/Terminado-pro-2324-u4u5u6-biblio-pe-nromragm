package org.pebiblioteca
import org.pebiblioteca.UtilidadesBiblioteca.generarUUID

fun main() {
    // Crear libros
    val libro1 = Libro(generarUUID(), "Hola", "Yo", 2024, "Examen")
    val libro2 = Libro(generarUUID(), "Adios", "Tu", 2024, "Programacion")
    val libro3 = Libro(generarUUID(), "Voy", "a", 2024, "Suspender")

    //Inicializar el regustro de prestamos y el gestor de biblioteca
    val registroPrestamos = RegistroPrestamos()
    val gestorBiblioteca = GestorBiblioteca(registroPrestamos)

    // Agregar los libros a la biblioteca
    gestorBiblioteca.agregarLibro(libro1)
    gestorBiblioteca.agregarLibro(libro2)
    gestorBiblioteca.agregarLibro(libro3)

    // Crear usuarios
    val usuario1 = Usuario(generarUUID(), "Papa")
    val usuario2 = Usuario(generarUUID(), "Mama")

    // Realizacion de prestamos y devoluciones de libros por parte de los usuarios
    gestorBiblioteca.realizarPrestamo(usuario1, gestorBiblioteca.catalogo[0])
    gestorBiblioteca.realizarPrestamo(usuario1, gestorBiblioteca.catalogo[0])

    gestorBiblioteca.realizarPrestamo(usuario2, gestorBiblioteca.catalogo[1])

    gestorBiblioteca.realizarDevolucion(usuario1, gestorBiblioteca.catalogo[0])
    gestorBiblioteca.realizarDevolucion(usuario1, gestorBiblioteca.catalogo[0])

    // Consulta del historial de prestamos de un libro y de un usuario especificos
    registroPrestamos.consultarHistorialPrestamosLibro(libro1)
    registroPrestamos.consultarHistorialPrestamosUsuario(usuario1)

    gestorBiblioteca.mostrarEstadoLibros()
}