class Tiempo (var hora: Int){
    var minutos: Int = 0
    var segundos: Int = 0
    constructor(hora: Int, minutoS: Int, segundoS: Int) : this(hora){
        minutos = minutoS
        segundos = segundoS

    }
    init {
        if (segundos > 60){
            val minsExtra: Int = segundos/60
            val segsReales: Int = segundos%60
            minutos += minsExtra
            segundos = segsReales
        }
        if (minutos > 60){
            val horasExtra: Int = minutos/60
            val minsReales: Int = minutos%60
            hora += horasExtra
            minutos = minsReales
        }
        require(hora >= 0) {"La hora no puede ser menor que cero"}
        require(minutos >= 0) {"Los minutos no pueden ser menor que cero"}
        require(segundos >= 0) {"Los segundos no pueden ser menor que cero"}
        require(hora <= 23){"La hora no puede ser mayor de las que hay en el día (0 - 23)"}
    }
    override fun toString(): String {
        val segs:String = if (segundos < 10){ "0$segundos" }
                            else { "$segundos" }
        val mins:String = if (minutos < 10){ "0$minutos" }
                            else { "$minutos" }
        val horas:String = if (hora < 10){ "0$hora" }
                            else { "$hora" }
        return "$horas:$mins:$segs"
    }
}

fun main() {
    println("Introduce la hora:\nSegundos: ")
    val segundos: Int = readln().toInt()
    println("Minutos: ")
    val minutos: Int = readln().toInt()
    println("Horas: ")
    val horas: Int = readln().toInt()
    val tuTiempo = Tiempo(horas, minutos, segundos)
    println(tuTiempo.toString())
}