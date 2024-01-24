package pOO_IV

import kotlin.random.Random
import pOO_III.Robot
import pOO_III.Direccion

class Robot2(nombre: String) : Robot(nombre) {

    init {
        posX = Random.nextInt(-5, 6)
        posY = 0
        direccion = Direccion.PositiveX
    }

    override fun cambiarDireccion() {
        super.cambiarDireccion()
        if (posX > 0) {
            direccion = when (direccion) {
                Direccion.PositiveX -> Direccion.NegativeX
                Direccion.NegativeX -> Direccion.PositiveX
                Direccion.PositiveY -> Direccion.NegativeY
                Direccion.NegativeY -> Direccion.PositiveY
            }
        } else if (posX < 0) {
            direccion = when (direccion) {
                Direccion.PositiveX -> Direccion.PositiveY
                Direccion.PositiveY -> Direccion.NegativeX
                Direccion.NegativeX -> Direccion.NegativeY
                Direccion.NegativeY -> Direccion.PositiveX
            }
        }
    }
}

class Robot3(nombre: String) : Robot(nombre) {

    init {
        posX = 0
        posY = Random.nextInt(-10, 11)
        direccion = obtenerDireccionAleatoria()
    }

    private fun obtenerDireccionAleatoria(): Direccion {
        return when (Random.nextInt(4)) {
            0 -> Direccion.PositiveX
            1 -> Direccion.NegativeX
            2 -> Direccion.PositiveY
            else -> Direccion.NegativeY
        }
    }

    override fun cambiarDireccion() {
        super.cambiarDireccion()
        direccion = when (direccion) {
            Direccion.PositiveX -> Direccion.NegativeY
            Direccion.NegativeY -> Direccion.NegativeX
            Direccion.NegativeX -> Direccion.PositiveY
            Direccion.PositiveY -> Direccion.PositiveX

        }
    }
}

class Robot4(nombre: String) : Robot(nombre) {

    init {
        posX = Random.nextInt(-5, 5)
        posY = Random.nextInt(-5, 5)
        direccion = obtenerDireccionAleatoria()
    }

    private fun obtenerDireccionAleatoria(): Direccion {
        return when (Random.nextInt(4)) {
            0 -> Direccion.PositiveX
            1 -> Direccion.NegativeX
            2 -> Direccion.PositiveY
            else -> Direccion.NegativeY
        }
    }

    override fun cambiarDireccion() {
        super.cambiarDireccion()
        val nuevaDireccion = obtenerDireccionAleatoria()
        while (nuevaDireccion == direccion) {
            cambiarDireccion()
        }
        direccion = nuevaDireccion
    }
}


fun main() {
    val robot2 = Robot2("DAW1A")
    val robot3 = Robot3("DAW1B")
    val robot4 = Robot4("DAM1")

    var fullpasos: Array<Array<Int>> = arrayOf()
    var pasos: Array<Int> = arrayOf()


    for (i in 1..5) { // Realiza movimientos cinco veces
        val paso = (-25..25).random()
        pasos += paso
    }
    fullpasos += pasos

    for (movimientos in fullpasos){
        robot2.mover(movimientos)
        println(robot2)
    }
    for (movimientos in fullpasos){
        robot3.mover(movimientos)
        println(robot2)
    }
    for (movimientos in fullpasos){
        robot4.mover(movimientos)
        println(robot2)
    }

}
