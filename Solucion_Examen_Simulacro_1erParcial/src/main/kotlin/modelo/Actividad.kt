package com.example.solucion_examen_simulacro1erparcial.modelo

abstract class Actividad(
        open val nombre: String,
        open var completada: Boolean = false
    ) {
        open fun marcarComoCompletada() {
            completada = true
            println("Actividad '$nombre' completada.")
        }

        override fun toString():String {
           return( "Nombre: $nombre Estado: ${if (completada) "Completada" else "Pendiente"}")
        }
    }

