class Persona(var peso: Double, var altura: Double) {

    var nombre: String = "Sin nombre"

    init {
        require(nombre.isNotBlank()){"El nombre no debe estar vacio."}
    }

    private val imc: Double = peso/(altura*altura)

    constructor(nombre: String, peso: Double, altura: Double) : this(peso, altura) {
        this.nombre = nombre
    }

    fun saludar():String{
        return "Hola, me llamo $nombre. Un placer!"
    }

    fun alturaEncimaMedia(): Boolean {
        return altura >= 1.75
    }

    fun pesoEncimaMedia(): Boolean {
        return peso >= 70
    }

    private fun obtenerDescImc(): String {
        return when {
            imc < 18.5 -> "peso insuficiente"
            imc in 18.5..24.9 -> "peso saludable"
            imc in 25.0..29.9 -> "sobrepeso"
            else -> "obesidad"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Persona) return false
        return this.peso == other.peso && this.altura == other.altura && this.nombre == other.nombre
    }

    override fun hashCode(): Int {
        return listOf(peso, altura, nombre).hashCode()
    }

    override fun toString(): String {
        return "Persona: Nombre = $nombre, Peso: ${peso}kg, Altura: ${altura}m, IMC: $imc"
    }
}