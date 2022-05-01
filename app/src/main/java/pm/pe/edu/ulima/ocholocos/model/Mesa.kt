package pm.pe.edu.ulima.ocholocos.model

import kotlin.random.Random

class Mesa {
    private var mazo : MutableList<Carta> = mutableListOf()
    private var cartaMedio : Carta? = null
    private var cementerio : MutableList<Carta> = mutableListOf()

    constructor(){
        this.mazo.addAll(crear52Cartas())
        this.mazo.shuffle(Random(666))
    }

    fun crear52Cartas():MutableList<Carta>{
        var cartasAux : MutableList<Carta> = mutableListOf()
        lateinit var cartaAux : Carta
        for (i in 1..4){
            for (j in 1..13){
                cartaAux = Carta(i,j)
                cartasAux.add(cartaAux)
            }
        }
        return cartasAux
    }
}