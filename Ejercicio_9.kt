class Cuenta (private val iban: String, private var saldo: Int){
    init {
        val error: String = "El identificador bancario debe tener 20 dígitos con la estructura:\n" +
                "4444 4444 123456789012 [4 digitos - 4 digitos - 12 digitos]"
        val espacios: Int = iban.count { it == ' ' }
        val idDividido: List<String> = (iban).split(" ")
        require(iban.length == 22) {error}
        require(espacios == 2) {error}
        require(idDividido[0].length == 4) {error}
        require(idDividido[1].length == 4) {error}
        require(idDividido[2].length == 12) {error}
    }
    override fun toString(): String { return "Saldo de $iban: $saldo" }
    fun consultaIdentificador(): String{
        return iban
    }
    fun consultaSaldo(): Int{
        return saldo
    }
    fun abonar(abono: Int): String{
        if (abono <= 0){
            return "Cantidad a abonar insuficiente"
        } else {
            saldo += abono
            return  "$abono€ abonados. (Cuenta $iban) Saldo actual: $saldo€"}
    }
    fun pagar(pago: Int): String{
        if (pago <= 0){
            return "Cantidad a pagar ilógica"
        } else {
            saldo -= pago
            return  "$pago€ deducidos. (Cuenta $iban) Saldo actual: $saldo€"}
    }

}
class Persona (private val DNI: String){
    private var cuentas: Array<Cuenta> = arrayOf<Cuenta>()
    companion object{
        private val cantidadMaxCuentas: Int = 3
    }
    constructor(DNI: String, arrayDeCuentas: Array<Cuenta>) : this(DNI){
        require(arrayDeCuentas.size <= cantidadMaxCuentas) {"No es posible asociar más de 3 cuentas al individuo"}
        cuentas = arrayDeCuentas
    }
    init {
        val letraDNI = DNI[8].toString()
        val cadenaNumerica = DNI.dropLast(1)
        require(DNI.length == 9) { "Dni de longitud incorrecta" }
        require(Regex("[A-Z]").matches(letraDNI)) { "Error (por la letra final) en el DNI" }
        require(!Regex("[^0-9]").matches(cadenaNumerica)) { "Error (de cadena numérica) en el DNI" }
    }
    fun asociarCuenta(cuenta: Cuenta): String{
        val cantidadActualCuentas: Int = cuentas.size
        if (cantidadActualCuentas < 3){
            cuentas += cuenta
            return "Cuenta ${cuenta.consultaIdentificador()} asociada correctamente al usuario $DNI"
        } else { return "No es posible asociar más cuentas al individuo" }
    }
    fun tieneDeuda(): String{
        for (cuenta in cuentas){
            if(cuenta.consultaSaldo() < 0){
                return "$DNI debe dinero"
            }
        }
        return "$DNI no tiene deudas"
    }

}
fun main() {
    fun transferencia(cuentaDondeSacar: Cuenta, cuentaDondeMeter: Cuenta, cantidad:Int): Array<Cuenta> {
    cuentaDondeSacar.pagar(cantidad)
    cuentaDondeMeter.abonar(cantidad)
    println("Cuenta " + cuentaDondeMeter.consultaIdentificador() +
            ", ha transferido $cantidad€ a " + cuentaDondeMeter.consultaIdentificador())
    val cuentas = arrayOf(cuentaDondeSacar, cuentaDondeMeter)
    return cuentas
    }
    var cuentaTrabajo = Cuenta("0000 4444 333001576980", 0)
    var cuentaAlquiler = Cuenta("0000 4443 220200600451", 700)
    val Jeremy = Persona("11223344X")
    println(Jeremy.asociarCuenta(cuentaTrabajo))
    println(Jeremy.asociarCuenta(cuentaAlquiler))
    println(cuentaTrabajo.abonar(1100))
    println(cuentaAlquiler.pagar(750))
    println(Jeremy.tieneDeuda())
    val traspaso = transferencia(cuentaTrabajo, cuentaAlquiler, 350)
    cuentaTrabajo = traspaso[0]
    cuentaAlquiler = traspaso[1]
    println(Jeremy.tieneDeuda())

}