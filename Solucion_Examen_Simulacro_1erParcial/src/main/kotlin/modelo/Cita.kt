package com.example.solucion_examen_simulacro1erparcial.modelo

import java.time.LocalDateTime

class Cita(
    override val nombre: String,
    override var completada: Boolean = false,
    val fechaHora: LocalDateTime,
    val lugar: String,
    val personas: MutableList<Persona> = mutableListOf()
) : Actividad(nombre, completada), Recordatorio {

    override fun programarRecordatorio() {
        println("Recordatorio programado para la cita '$nombre' en $fechaHora en $lugar")
    }

    override fun cancelarRecordatorio() {
        println("Recordatorio cancelado para la cita '$nombre'")
    }

    fun agregarPersona(persona: Persona) {
        personas.add(persona)
    }

    override fun mostrarDetalles() {
        super.mostrarDetalles()
        println("Fecha y Hora: $fechaHora")
        println("Lugar: $lugar")
        println("Personas invitadas: ${personas.joinToString { it.nombre }}")
    }
}
data class Persona(val nombre: String, val telefono: String)