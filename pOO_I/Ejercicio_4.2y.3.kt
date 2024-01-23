package pOO_I

class Persona (var peso: Double, var altura: Double){
    /*Ejercicio 4.2*/
    var nombre: String? = null
    var imc: Double = peso/(altura*altura)
    constructor(nombre: String, peso: Double, altura: Double): this(peso, altura){
        require(nombre!= ""){""}
        this.nombre = nombre
    }
    override fun toString(): String = "${nombre?: ""}\nPeso: ${peso}kg .\nAltura:${altura}m .\nIMC:${"%.2f".format(imc)} ."
    fun cambioAltura(alturA: Double): String{
        this.altura = alturA
        this.imc = peso/(alturA*alturA)
        return "La altura de $nombre ha sido cambiada correctamente"
    }
    fun esIgual(otraPersona: Persona): Boolean{
        return this.equals(otraPersona)
    }

    /*Ejercicio 4.3*/
    fun saludar(): String{
        return "¡Hola! Me llamo $nombre"
    }
    private fun alturaEncimaMedia(): Boolean{
        return altura >= 1.75
    }
    private fun pesoEncimaMedia(): Boolean{
        return peso >= 70.0
    }
    private fun obtenerDescImc(): String{
        return when {
            (imc < 18.5) -> "peso insuficiente"
            ((imc >= 18.5) and (imc < 24.9)) -> "peso saludable"
            ((imc >= 25.0) and (imc <= 29.9)) -> "sobrepeso"
            else -> {"obesidad"}
        }
    }
    fun obtenerDesc(): String{
        val descImc = obtenerDescImc()
        val mediaAltura = if (this.alturaEncimaMedia()) {"Por encima de la media"}
                            else{ "Por debajo de la media" }
        val mediaPeso = if (this.pesoEncimaMedia()) {"Por encima de la media"}
                            else{ "Por debajo de la media" }
        return "$nombre con una altura de ${altura}m ($mediaAltura) " +
                "y un peso de ${peso}kg ($mediaPeso) tiene un IMC " +
                "de ${"%.2f".format(imc)} ($descImc)"
    }
}
fun main(){
    /*Ejercicio 4.2*/
    val persona1 = Persona(85.4, 1.72)
    val persona2 = Persona("José", 75.1, 1.61)
    val persona3 = Persona("María", 62.9, 1.58)

    println(persona1.toString())
    println("Asignale un nombre a la persona1: ")
    var cambioNombre = readln()
    if ((cambioNombre == "") or (false)){
        cambioNombre = "Desconocido"
    }
    persona1.nombre = cambioNombre
    println(persona1.toString())

    println(persona3.toString())
    println(persona3.cambioAltura(1.80))
    println(persona3.toString())

    println(persona2.toString())
    println(persona2.cambioAltura(1.80))
    println(persona2.esIgual(persona3))

    /*Ejercicio 4.3*/
    println(persona2.cambioAltura(1.61))
    println(persona3.cambioAltura(1.58))
    val persona4 = Persona("Paco", 95.3, 2.07)
    val persona5 = Persona("Clara", 57.8, 1.60)

    val listaPersona = listOf(persona1, persona2, persona3, persona4, persona5)
    for (individuo in listaPersona){
        println(individuo.saludar())
        println(individuo.obtenerDesc())
    }
}