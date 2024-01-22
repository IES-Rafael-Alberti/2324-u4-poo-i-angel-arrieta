package pOO_I

class Rectangulo(val base: Double, val altura: Double){
    fun calcArea(): Double{
        return base * altura
    }
    fun calcPerimetro(): Double{
        return base * 2 + altura * 2
    }
    override fun toString() = "Tiene $base m de base y $altura m de altura"
    /* Cuando se muestre por pantalla la instancia de un objeto de esta clase,
        se mostrara esta información en vez de el id del objeto en la memoria
        del ordenador*/

}

fun main() {
    val rectanguloComun = Rectangulo(4.5, 8.toDouble())
    val rectanguloAncho = Rectangulo(15.toDouble(), 2.5)
    val rectanguloLargo = Rectangulo(2.toDouble(), 21.toDouble())
    println("rectanguloComun: ${rectanguloComun}\n" +
            "Area: ${rectanguloComun.calcArea()}m². Perimetro: ${rectanguloComun.calcPerimetro()}m")
    println("rectanguloLargo: ${rectanguloLargo}\n" +
            "Area: ${rectanguloLargo.calcArea()}m². Perimetro: ${rectanguloLargo.calcPerimetro()}m")
    println("rectanguloAncho: ${rectanguloAncho}\n" +
            "Area: ${rectanguloAncho.calcArea()}m². Perimetro: ${rectanguloAncho.calcPerimetro()}m")
}