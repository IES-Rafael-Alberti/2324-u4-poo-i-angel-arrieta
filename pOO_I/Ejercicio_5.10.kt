package pOO_I

class Libro(private var titulo:String, private var autor: String){
    private var cantPaginas:Int = 1
    private var calificacion: Int = 5
    init {
        require(cantPaginas > 0) { "Debe tener al menos 1 página" }
        require( (calificacion >= 0) and (calificacion <= 10) ) { "Debe valorarse entre el 0 al 10" }
    }
    constructor (titulO: String, autoR: String, cantPaginaS: Int): this(titulO, autoR){
        cantPaginas = cantPaginaS
    }constructor (titulO: String, autoR: String, cantPaginaS: Int, calificacioN: Int): this(titulO, autoR){
        cantPaginas = cantPaginaS
        calificacion = calificacioN
    }
    fun cambioTitulo(nuevoTitulo: String){
        titulo = nuevoTitulo
    }fun cambioAutor(nuevoAutor: String){
         autor = nuevoAutor
    }fun cambioPaginas(nuevaNumeracion: Int){
        cantPaginas = nuevaNumeracion
    }fun cambioCalificacion(nuevaCalificacion: Int){
        calificacion = nuevaCalificacion
    }
    fun titulo(): String{
        return titulo
    }fun autor(): String {
        return autor
    }fun cantPaginas(): Int {
        return cantPaginas
    }fun calificacion(): Int{
        return calificacion
    }
    override fun toString(): String {
        return "Titulo: $titulo.\nAutor: $autor.\n" +
                "Cantidad de páginas: $cantPaginas.\n" +
                "Calificación personal: $calificacion."

    }
}
class ConjuntoLibros () {
    private var conjunto: Set<Libro> = setOf()
    companion object{
        private val cantidadMaxLibros: Int = 5
    }
    init {
        require(conjunto.size <= cantidadMaxLibros){ "No es posible añadir más libros al conjunto" }
        require(conjunto.size >= 0){ "No es posible eliminar más libros del conjunto" }
    }
    constructor (libro: Libro): this(){
        conjunto =  setOf(libro)
    }constructor (libro1: Libro, libro2: Libro): this(){
        conjunto =  setOf(libro1, libro2)
    }constructor (libro1: Libro, libro2: Libro, libro3: Libro): this(){
        conjunto =  setOf(libro1, libro2, libro3)
    }constructor (libro1: Libro, libro2: Libro, libro3: Libro, libro4: Libro): this(){
        conjunto =  setOf(libro1, libro2, libro3, libro4)
    }constructor (libro1: Libro, libro2: Libro, libro3: Libro, libro4: Libro, libro5: Libro): this(){
        conjunto =  setOf(libro1, libro2, libro3, libro4, libro5)
    }
    fun anadirLibro(libroNuevo: Libro){
        conjunto += libroNuevo
    }
    private fun quitarDelConjunto (librosAQuitar: MutableList<Libro>){
        var diferencia: Int = 0
            for (libro in librosAQuitar){
                conjunto = conjunto.filter { it !in setOf(libro) }.toSet()
                diferencia += 1
            }
    } fun quitarPorTitulo(tituloLibro: String): String{
        var accionRealizada: Boolean = false
        val librosQueQuitar: MutableList<Libro> = mutableListOf()
        for (libro in conjunto){
            if(libro.titulo() == tituloLibro){
                librosQueQuitar.add(libro)
                accionRealizada = true
            }
        }
        if ( accionRealizada ) {
            val mensaje: String = if (librosQueQuitar.size > 1) { "Libros quitados de la colección" }
            else { "Libro quitado de la colección" }
            quitarDelConjunto(librosQueQuitar)
            return mensaje
        } else {
            return "No se ha encontrado ningún libro con el título especificado"
        }
    } fun quitarPorAutor(autorLibro: String): String{
        var accionRealizada: Boolean = false
        val librosQueQuitar: MutableList<Libro> = mutableListOf()
        for (libro in conjunto){
            if(libro.autor() == autorLibro){
                librosQueQuitar.add(libro)
                accionRealizada = true
            }
        }
        if ( accionRealizada ) {
            val mensaje: String = if (librosQueQuitar.size > 1) { "Libros quitados de la colección" }
            else { "Libro quitado de la colección" }
            quitarDelConjunto(librosQueQuitar)
            return mensaje
        } else {
            return "No se ha encontrado ningún libro con el autor especificado"
        }
    }
    fun mostrarExtremosCalificacion(): String{
        var resenasLibros: String = ""
        val librosQueMostrar: MutableList<Libro> = mutableListOf()
        val calificacionesLibros: MutableList<Int> = mutableListOf()
        val libroToCalificacion: MutableMap<Libro, Int> = mutableMapOf()
        for (libro in conjunto){
            calificacionesLibros.add(libro.calificacion())
            libroToCalificacion += (libro to libro.calificacion())
        }
        val mayorCalificacion = calificacionesLibros.max()
        val menorCalificacion = calificacionesLibros.min()
        for((libro, calificacion) in libroToCalificacion){
            if (calificacion == mayorCalificacion){
                librosQueMostrar += libro
            }
            if (calificacion == menorCalificacion){
                librosQueMostrar += libro
            }
        }
        for (libro in librosQueMostrar){
            resenasLibros += libro.toString()
        }
        return resenasLibros
    }
    override fun toString(): String {
        var resenasLibros: String = ""
        if (conjunto.isEmpty()){
            return "No hay libros para mostrar"
        } else {
            for (libro in conjunto){
                resenasLibros += libro.toString() + "\n"
            }
            return resenasLibros
        }
    }
}
fun main() {
    val librosDeMiInfancia = ConjuntoLibros()
    val libroFantasia = Libro("Eragon", "Christopher Paolini", 544, 7)
    val libroInfantil = Libro("Viaje al Reino de la Fantasía","Geronimo Stilton", 330, 5)
    librosDeMiInfancia.anadirLibro(libroInfantil)
    librosDeMiInfancia.anadirLibro(libroFantasia)
    println(librosDeMiInfancia.toString())
    println(librosDeMiInfancia.quitarPorAutor("Geronimo Stilton"))
    println(librosDeMiInfancia.quitarPorTitulo("Eragon"))
    val libroJuvenil = Libro("Eldest", "Christopher Paolini", 704, 9)
    librosDeMiInfancia.anadirLibro(libroJuvenil)
    println(librosDeMiInfancia.toString())
}