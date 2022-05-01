package pm.pe.edu.ulima.ocholocos.model

class Player{
    var id : Int
    var nombre : String
    private var mano : MutableList<Carta> = mutableListOf()
    private var isWinner : Boolean = false

    constructor(nombre : String, id : Int){
        this.nombre = nombre
        this.id = id
        var aux = Carta(1,12)
        this.mano.add(aux)
    }

    fun Victoria(numCards : Int){
        if(numCards == 0){
            isWinner = true
        }
    }

    fun addCardHand (carta: Carta){
        this.mano.add(carta)
    }

   /* fun removeCardHand (carta:Carta){
        this.mano.remove(carta)
    }*/

    fun removeCardHand (palo: Int, numero: Int){
        var aux = Carta(palo,numero)
        this.mano.remove(aux)
    }

    fun obtenerNumeroMano():Int{
        return this.mano.count()
    }
}
