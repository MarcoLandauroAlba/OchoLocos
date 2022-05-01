package pm.pe.edu.ulima.ocholocos.model

class Player{
    private var id : Int
    var nombre : String
    private var mano : MutableList<Carta> = mutableListOf()
    private var isWinner : Boolean = false

    constructor(nombre : String, id : Int){
        this.nombre = nombre
        this.id = id
    }

    fun Victoria(numCards : Int) : Unit{
        if(numCards == 0){
            isWinner = true
        }
    }
}