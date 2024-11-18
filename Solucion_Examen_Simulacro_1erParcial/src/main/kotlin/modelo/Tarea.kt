package com.example.solucion_examen_simulacro1erparcial.modelo

import java.time.LocalDate
import java.time.LocalDateTime

class Tarea(
    nombre: String,
    completada: Boolean = false,
    val fechaLimite: LocalDate,        // Fecha límite de la tarea
    val urgencia: Urgencia,            // Grado de urgencia de la tarea
    private val notificacion: Notificacion? = null
) : Actividad(nombre,completada),Recordatorio {

    // Clase interna que maneja las notificaciones
    inner class Notificacion(
        val fechaRecordatorio: LocalDateTime   // Fecha y hora para el recordatorio
    ) {
        fun mostrarNotificacion() {
            println("Notificación: Recordatorio de la tarea '$nombre' a las $fechaRecordatorio")
        }
    }

    override fun programarRecordatorio() {
        notificacion?.let {
            println("Recordatorio programado para la tarea '$nombre' el ${it.fechaRecordatorio}")
            // Aquí iría la lógica para programar la notificación en Android
        }
    }

    override fun cancelarRecordatorio() {
        println("Recordatorio cancelado para la tarea '$nombre'")
        // Aquí iría la lógica para cancelar la notificación en Android
    }
    enum class Urgencia{
        BAJO,MEDIO,ALTO
    }


}
