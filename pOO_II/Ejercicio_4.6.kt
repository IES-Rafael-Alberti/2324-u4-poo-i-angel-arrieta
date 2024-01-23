package pOO_II

data class Domicilio(val calle: String, val numero: Int) {
    fun dirCompleta(): String {
        return "$calle $numero"
    }
}

data class Cliente(val nombre: String, val domicilio: Domicilio)

data class Compra(val cliente: Cliente, val dia: Int, val monto: Double)

class RepositorioCompras {
    private val compras: MutableList<Compra> = mutableListOf()

    fun agregarCompra(compra: Compra) {
        compras.add(compra)
    }

    fun domicilios(): String {
        var domiciliosUnicos: String = ""
        for (compra in compras) {
            domiciliosUnicos += compra.cliente.domicilio.dirCompleta() + "\n"
        }
        return domiciliosUnicos
    }
}

fun main() {
    val repositorio = RepositorioCompras()

    val compra1 = Compra(Cliente("Nuria Costa", Domicilio("Calle Las Flores", 355)), 5, 12780.78)
    val compra2 = Compra(Cliente("Jorge Russo", Domicilio("Mirasol", 218)), 7, 699.0)
    val compra3 = Compra(Cliente("Nuria Costa", Domicilio("Calle Las Flores", 355)), 7, 532.90)
    val compra4 = Compra(Cliente("Julián Rodriguez", Domicilio("La Mancha", 761)), 12, 5715.99)
    val compra5 = Compra(Cliente("Jorge Russo", Domicilio("Mirasol", 218)), 15, 958.0)

    repositorio.agregarCompra(compra1)
    repositorio.agregarCompra(compra2)
    repositorio.agregarCompra(compra3)
    repositorio.agregarCompra(compra4)
    repositorio.agregarCompra(compra5)

    val domicilios = repositorio.domicilios()

    println(domicilios)
}
