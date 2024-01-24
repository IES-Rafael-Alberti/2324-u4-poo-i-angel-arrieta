import java.util.Scanner

fun mostrarTablero(tablero: Array<CharArray>) {
    println("  0 1 2")
    for (i in tablero.indices) {
        print("$i ")
        for (j in tablero[i].indices) {
            print("${tablero[i][j]} ")
        }
        println()
    }
}

fun pedirCoordenada(tipo: String): Int {
    val scanner = Scanner(System.`in`)
    print("Ingrese la $tipo (0, 1, 2): ")
    var coordenada = scanner.nextInt()

    while (coordenada !in 0..2) {
        print("¡Coordenada inválida! Ingrese la $tipo (0, 1, 2): ")
        coordenada = scanner.nextInt()
    }

    return coordenada
}

fun esMovimientoValido(tablero: Array<CharArray>, fila: Int, columna: Int): Boolean {
    return tablero[fila][columna] == ' '
}

fun realizarMovimiento(tablero: Array<CharArray>, fila: Int, columna: Int, jugador: Char) {
    tablero[fila][columna] = jugador
}

fun haGanado(tablero: Array<CharArray>, jugador: Char): Boolean {
    // Verificar filas y columnas
    for (i in 0..2) {
        if ((tablero[i][0] == jugador && tablero[i][1] == jugador && tablero[i][2] == jugador) ||
            (tablero[0][i] == jugador && tablero[1][i] == jugador && tablero[2][i] == jugador)
        ) {
            return true
        }
    }

    // Verificar diagonales
    if ((tablero[0][0] == jugador && tablero[1][1] == jugador && tablero[2][2] == jugador) ||
        (tablero[0][2] == jugador && tablero[1][1] == jugador && tablero[2][0] == jugador)
    ) {
        return true
    }

    return false
}

fun tableroLleno(tablero: Array<CharArray>): Boolean {
    for (fila in tablero) {
        for (casilla in fila) {
            if (casilla == ' ') {
                return false
            }
        }
    }
    return true
}

fun main() {
    val tablero = Array(3) { CharArray(3) { ' ' } }
    var jugadorActual = 'X'

    while (true) {
        mostrarTablero(tablero)
        println("Turno del jugador $jugadorActual")
        val fila = pedirCoordenada("fila")
        val columna = pedirCoordenada("columna")

        if (esMovimientoValido(tablero, fila, columna)) {
            realizarMovimiento(tablero, fila, columna, jugadorActual)

            if (haGanado(tablero, jugadorActual)) {
                mostrarTablero(tablero)
                println("¡Jugador $jugadorActual ha ganado!")
                break
            } else if (tableroLleno(tablero)) {
                mostrarTablero(tablero)
                println("¡Empate!")
                break
            }

            jugadorActual = if (jugadorActual == 'X') 'O' else 'X'
        } else {
            println("¡Movimiento inválido! La casilla ya está ocupada.")
        }
    }
}