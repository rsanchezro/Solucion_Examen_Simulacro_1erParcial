package com.example.solucion_examen_simulacro1erparcial.modelo

abstract class Actividad(
        open val nombre: String,
        open var completada: Boolean = false
    ) {
        open fun marcarComoCompletada() {
            completada = true
            println("Actividad '$nombre' completada.")
        }

        open fun mostrarDetalles() {
            println("Nombre: $nombre")
            println("Estado: ${if (completada) "Completada" else "Pendiente"}")
        }
    }
fun ArrayList<Actividad>.filtrar(condicion:(Actividad)->Boolean):ArrayList<Actividad>
 {
     var milistafiltrada=ArrayList<Actividad>()
     this.forEach{
         if(condicion(it))
         {
             milistafiltrada.add(it)
         }
     }
     return milistafiltrada

}

