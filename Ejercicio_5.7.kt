class Coche (val matricula: String, val marca: String, val modelo: String) {
    var numeroPuertas: Int? = null
    var color: String? = null
    var cvPotencia: Double? = null
    constructor(matricula: String, marca: String, modelo: String, numbPuertas: Int, coloR: String, potencia: Double) : this(matricula, marca, modelo){
        numeroPuertas = numbPuertas
        color = coloR
        cvPotencia = potencia
    }
    constructor(matricula: String, marca: String, modelo: String, coloR: String) : this(matricula, marca, modelo){
        color = coloR
    }
    constructor(matricula: String, marca: String, modelo: String, numbPuertas: Int, coloR: String) : this(matricula, marca, modelo){
        numeroPuertas = numbPuertas
        color = coloR
    }
    override fun toString() = "El coche de matrícula $matricula es un $marca $modelo.\n" +
                                "Otras especificaciones:\nNº Puertas: $numeroPuertas.\n" +
                                "Color: $color.\nCaballos de Potencia: $cvPotencia."
    fun repintar(pintura: String){
        color = pintura
        println("\n$matricula ha sido repintado")
    }
}

fun main() {
    val miCoche = Coche("4537 GHZ", "Opel", "Astra Coupe", 5, "Rojo", 147.0)
    val cochePapa = Coche("9235 BFD", "Citroën", "C4 cactus", "Celeste")
    val cocheTito = Coche("1722 JKL", "Honda", "Civic Sedán", 6, "Gris")
    println("${miCoche.toString()}\n\n${cochePapa.toString()}\n\n${cocheTito.toString()}")
    miCoche.repintar("Negro")
    cochePapa.repintar("Azul Marino")
    println("\n${miCoche.toString()}\n\n${cochePapa.toString()}")
}