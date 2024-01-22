package pOO_II

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class Tarea(val descripcion: String) {
     lateinit var estado: String
     var fechaRealizacion: LocalDateTime? = null
        constructor(descripcioN: String, estadO: String, fechaRealizacioN: LocalDateTime? = null) : this(descripcioN) {
            estado = estadO
            fechaRealizacion = fechaRealizacioN
        }
    }

class ListaTareas {
    private val tareas: MutableList<Tarea> = mutableListOf()

    fun agregarTarea(tarea: Tarea) {
        tareas.add(tarea)
    }

    fun eliminarTarea(index: Int) {
        if ((index >= 0) and (index < tareas.size) ) {
            tareas.removeAt(index)
            println("Tarea eliminada.")
        } else {
            println("Índice inválido.")
        }
    }
    fun mostrarTodasLasTareas() {
        for ((index, tarea) in tareas.withIndex()) {
            println("$index - ${tarea.descripcion} - Estado: ${tarea.estado}")
            if (tarea.estado == "REALIZADA") {
                println("   Fecha de realización: ${tarea.fechaRealizacion?.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"))}")
            }
        }
    }
}

fun main() {
    val listaTareas = ListaTareas()
    var opcion: Int? = 0

    while (opcion != 7) {
        println("\n---- Menú ----")
        println("1. Agregar tarea")
        println("2. Eliminar tarea")
        println("3. Mostrar todas las tareas")
        println("4. Cambiar estado de tarea a realizada")
        println("5. Mostrar tareas pendientes")
        println("6. Mostrar tareas realizadas")
        println("7. Salir")

        print("Ingrese la opción: ")
        opcion = readLine()?.toIntOrNull()
        when (opcion) {
            1 -> {
                print("Ingrese la descripción de la tarea: ")
                val descripcion = readLine() ?: ""
                listaTareas.agregarTarea(Tarea(descripcion))
            }
            2 -> {
                print("Ingrese el índice de la tarea a eliminar: ")
                val index = readLine()?.toIntOrNull() ?: -1
                listaTareas.eliminarTarea(index)
            }
            3 -> listaTareas.mostrarTodasLasTareas()
            7 -> {
                println("Saliendo del programa.")
            }
            else -> println("Opción inválida. Intente nuevamente.")
        }
    }
}
