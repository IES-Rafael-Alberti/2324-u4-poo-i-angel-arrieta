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
    var conjunto: Array<Libro> = arrayOf()
    companion object{
        private val cantidadMaxLibros: Int = 5
    }
    init {
        require(conjunto.size <= cantidadMaxLibros){ "No es posible añadir más libros al conjunto" }
        require(conjunto.size >= 0){ "No es posible eliminar más libros del conjunto" }
    }
    constructor (libro: Libro): this(){
        conjunto =  arrayOf(libro)
    }constructor (libro1: Libro, libro2: Libro): this(){
        conjunto =  arrayOf(libro1, libro2)
    }constructor (libro1: Libro, libro2: Libro, libro3: Libro): this(){
        conjunto =  arrayOf(libro1, libro2, libro3)
    }constructor (libro1: Libro, libro2: Libro, libro3: Libro, libro4: Libro): this(){
        conjunto =  arrayOf(libro1, libro2, libro3, libro4)
    }constructor (libro1: Libro, libro2: Libro, libro3: Libro, libro4: Libro, libro5: Libro): this(){
        conjunto =  arrayOf(libro1, libro2, libro3, libro4, libro5)
    }
    fun anadirLibro(libroNuevo: Libro){
        conjunto += libroNuevo
    }
    fun quitarPorTitulo(tituloLibro: String): String{
        var accionRealizada: Boolean = false
        var librosQueQuitar: List<Int> = listOf()
        for (libro in conjunto){
            if(libro.titulo() == tituloLibro){
                librosQueQuitar += conjunto.indexOf(libro)
                accionRealizada = true
            }
        }
        if ( accionRealizada ) {
            val mensaje: String = if (librosQueQuitar.size > 1) { "Libros quitados de la colección" }
            else { "Libro quitado de la colección" }
            var diferencia: Int = 0
            for (indiceLibro in librosQueQuitar){
                conjunto.drop(indiceLibro-diferencia)
                diferencia += 1
            }
            return mensaje
        } else {
            return "No se ha encontrado ningún libro con el título especificado"
        }

    }
    fun quitarPorAutor(autorLibro: String): String{
        var accionRealizada: Boolean = false
        var librosQueQuitar: List<Int> = listOf()
        for (libro in conjunto){
            if(libro.autor() == autorLibro){
                librosQueQuitar += conjunto.indexOf(libro)
                accionRealizada = true
            }
        }
        if ( accionRealizada ) {
            val mensaje: String = if (librosQueQuitar.size > 1) { "Libros quitados de la colección" }
            else { "Libro quitado de la colección" }
            var diferencia: Int = 0
            for (indiceLibro in librosQueQuitar){
                conjunto.drop(indiceLibro-diferencia)
                diferencia += 1
            }
            return mensaje
        } else {
            return "No se ha encontrado ningún libro con el autor especificado"
        }

    }
    fun mostrarExtremosCalificacion(){
        val calificacionesLibros: List<Int> = listOf()
        for (libro in conjunto){
            calificacionesLibros.addLast(libro.calificacion())
        }
       // var mayorCalificacion

    }
}
fun main() {
    val papa: List<Int> = listOf(7, 1, 7, 2)
    println(papa.max())
    println(papa.min())
}