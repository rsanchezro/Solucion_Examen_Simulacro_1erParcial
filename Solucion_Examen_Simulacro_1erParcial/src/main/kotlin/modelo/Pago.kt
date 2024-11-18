package com.example.solucion_examen_simulacro1erparcial.modelo

import java.time.LocalDate

class Pago(
    val monto: Double,
    val fechaPago: LocalDate,
    val metodoPago: String,
    var completado: Boolean = false
) {

    // Método para procesar el pago
    fun procesarPago() {
        if (!completado) {
            completado = true
            println("Pago de $monto procesado exitosamente el $fechaPago mediante $metodoPago.")
        } else {
            println("El pago de $monto ya estaba completado.")
        }
    }

    // Muestra los detalles del pago
    fun mostrarDetalles() {
        println("Monto: $monto")
        println("Fecha de Pago: $fechaPago")
        println("Método de Pago: $metodoPago")
        println("Estado: ${if (completado) "Completado" else "Pendiente"}")
    }


// Algoritmo para detectar pagos duplicados
fun detectarPagosDuplicados(pagos: List<Pago>): List<Pair<Pago, Pago>> {
    val duplicados = mutableListOf<Pair<Pago, Pago>>()

    for (i in pagos.indices) {
        for (j in i + 1 until pagos.size) {
            val pago1 = pagos[i]
            val pago2 = pagos[j]

            // Comprobamos duplicados por monto, fecha y método de pago
            if (pago1.monto == pago2.monto &&
                pago1.fechaPago == pago2.fechaPago &&
                pago1.metodoPago == pago2.metodoPago) {
                duplicados.add(pago1 to pago2)
            }
        }
    }

    return duplicados
}

// Algoritmo para calcular total de pagos pendientes y completados
fun calcularTotalesPagos(pagos: List<Pago>): Pair<Double, Double> {
    val totalPendiente = pagos.filter { !it.completado }.sumOf { it.monto }
    val totalCompletado = pagos.filter { it.completado }.sumOf { it.monto }

    println("Total pendiente: $$totalPendiente")
    println("Total completado: $$totalCompletado")

    return totalPendiente to totalCompletado
}


}

fun ArrayList<Pago>.calcular(funcion:(Pago)->Double):Double{
    var resultado:Double= 0.0
     this.forEach { resultado+=funcion(it) }
    return resultado
}