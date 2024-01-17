class Libro(private var titulo:String, private var autor: String){
    private var cantPaginas:Int = 1
    private var calificacion: Int = 5
    init {
        require(cantPaginas > 0) { "Debe tener al menos 1 página" }
        require( (calificacion >= 0) and (calificacion <= 10) ) { "Debe valorarse entre el 0 al 10" }
    }
    constructor (titulO: String, autoR: String, cantPaginaS: Int): this(titulO, autoR){
        cantPaginas = cantPaginaS
    }
    constructor (titulO: String, autoR: String, cantPaginaS: Int, calificacioN: Int): this(titulO, autoR){
        cantPaginas = cantPaginaS
        calificacion = calificacioN
    }
    fun cambioTitulo(nuevoTitulo: String){
        titulo = nuevoTitulo
    }
    fun cambioAutor(nuevoAutor: String){
         autor = nuevoAutor
    }fun cambioPaginas(nuevaNumeracion: Int){
        cantPaginas = nuevaNumeracion
    }
    fun cambioCalificacion(nuevaCalificacion: Int){
        calificacion = nuevaCalificacion
    }
    fun titulo(): String{
        return titulo
    }
    fun autor(): String {
        return autor
    }
    fun cantPaginas(): Int {
        return cantPaginas
    }
    fun calificacion(): Int{
        return calificacion
    }
}
class ConjuntoLibros () {
    private var conjunto: Array<Libro> = arrayOf()
    constructor (conjuntO: Array<Libro>): this(){
        conjunto = conjuntO
    }
}
fun main() {
    val libroFiccion = Libro("papa", "pepe", 7)
    println(libroFiccion.calificacion())
}