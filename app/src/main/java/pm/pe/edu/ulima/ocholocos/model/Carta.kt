package pm.pe.edu.ulima.ocholocos.model

class Carta {
    private val palo : Int
    private val num : Int

    constructor(palo: Int,numero : Int){
        this.palo = palo
        this.num = numero
    }

    override fun toString(): String {
        return "numero:${this.num},palo:${this.palo}"
    }
}