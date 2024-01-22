package pOO_I

class Persona (var peso: Double, var altura: Double){
    var nombre: String? = null
    var imc: Double = peso/(altura*altura)
    constructor(nombre: String, peso: Double, altura: Double): this(peso, altura){
        this.nombre = nombre
    }
    override fun toString(): String = "${nombre?: ""} Pesa $peso" + "kg y mide $altura" + "m. Tiene un IMC de $imc"
}
fun main(){
    /*Ejercicio 4.2*/
    val persona1 = Persona(85.4, 1.72)
    val persona2 = Persona("José", 75.1, 1.61)
    val persona3 = Persona("María", 62.9, 1.58)
    println(persona1.toString())
    println(persona2.toString())
    println(persona3.toString())
    /*
    println("Nombre de la persona1: ")
    var cambioNombre = readln()
    if ((cambioNombre == "") or (false)){
        cambioNombre = "Desconocido"
    }
    persona1.nombre = cambioNombre
    println("Nombre: ${persona1.nombre}.\nPeso: ${persona1.peso}.\nAltura: ${persona1.altura}")
    println("Persona3\nPeso: ${persona3.peso}.\nAltura: ${persona3.altura}.\nImc: ${persona3.imc}")
    persona3.altura = 1.80
    println("Persona3\nPeso: ${persona3.peso}.\nAltura: ${persona3.altura}.\nImc: ${persona3.imc}")
    */
}