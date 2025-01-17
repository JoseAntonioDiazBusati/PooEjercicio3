class Persona(var peso: Double, var altura: Double) {

    var nombre: String = "Sin nombre"

    init {
        require(nombre.isNotBlank()){"El nombre no debe estar vacio."}
    }

    private val imc: Double = peso/(altura*altura)

    constructor(nombre: String, peso: Double, altura: Double) : this(peso, altura) {
        this.nombre = nombre
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