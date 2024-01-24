package pOO_III

enum class Direccion {
    PositiveY, NegativeY, PositiveX, NegativeX
}

open class Robot(var nombre: String) {
    init {
        require(nombre.isNotBlank()) { "El nombre del robot no puede estar vacío" }
    }
    var posX: Int = 0

    var posY: Int = 0

    var direccion: Direccion = Direccion.PositiveY

    fun mover(pasos: Array<Int>) {
        for (paso in pasos) {
            when (direccion) {
                Direccion.PositiveX -> posX += paso
                Direccion.NegativeX -> posX -= paso
                Direccion.PositiveY -> posY += paso
                Direccion.NegativeY -> posY -= paso
            }
            if (paso > 0) { cambiarDireccion() }
        }
    }

    open fun cambiarDireccion() {
        direccion = when (direccion) {
            Direccion.PositiveY -> Direccion.NegativeX
            Direccion.NegativeX -> Direccion.NegativeY
            Direccion.NegativeY -> Direccion.PositiveX
            Direccion.PositiveX -> Direccion.PositiveY
        }
    }

    fun obtenerPosicion(): Pair<Int, Int> {
        return Pair(posX, posY)
    }

    fun obtenerDireccion(): Direccion {
        return direccion
    }

    override fun toString(): String {
        return "$nombre está en (${obtenerPosicion().first}, ${obtenerPosicion().second}). Mirando en dirección ${obtenerDireccion()}"
    }
}

fun main() {
    val movimientos = arrayOf(
        arrayOf<Int>(1, -5, 0, -9),
        arrayOf<Int>(3, 3, 5, 6, 1, 0, 0, -7),
        arrayOf<Int>(2, 1, 0, -1, 1, 1, -4),
        arrayOf<Int>(),
        arrayOf<Int>(3, 5)
    )

    val robot1 = Robot("R2D2")

    for (movimiento in movimientos) {
        robot1.mover(movimiento)
        println(robot1)
    }
}
