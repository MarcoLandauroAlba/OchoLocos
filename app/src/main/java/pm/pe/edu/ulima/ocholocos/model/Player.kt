package pm.pe.edu.ulima.ocholocos.model

import android.os.Build
import androidx.annotation.RequiresApi

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

    /*@RequiresApi(Build.VERSION_CODES.N)
    fun removeCardHand (palo: Int, numero: Int):Carta{
        var aux = Carta(palo,numero)
        this.mano.removeIf { carta:Carta -> carta.num ==numero && carta.palo == palo }
        return aux
    }*/

    fun obtenerNumeroMano():Int{
        return this.mano.count()
    }

    fun vermano(){
        this.mano.forEach{carta -> println(carta.toString()) }
    }
}
