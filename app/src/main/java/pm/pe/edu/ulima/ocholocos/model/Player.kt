package pm.pe.edu.ulima.ocholocos.model

class Player{
    var id : Int
    var nombre : String
    private var mano : MutableList<Carta> = mutableListOf()
    private var isWinner : Boolean = false

    constructor(nombre : String, id : Int){
        this.nombre = nombre
        this.id = id
    }

    fun Victoria(numCards : Int){
        if(numCards == 0){
            isWinner = true
        }
    }

    fun addCardHand (carta: Carta){
        this.mano.add(carta)
    }

    fun removeCardHand (carta:Carta){
        this.mano.remove(carta)
    }

    fun obtenerNumeroMano():Int{
        return this.mano.count()
    }
}
