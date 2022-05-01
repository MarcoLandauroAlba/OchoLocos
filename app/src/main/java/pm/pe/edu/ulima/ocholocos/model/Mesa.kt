package pm.pe.edu.ulima.ocholocos.model

import kotlin.random.Random

class Mesa {
    var mazo : MutableList<Carta> = mutableListOf()
    var cartaMedio : Carta? = null
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

    fun robarCarta():Carta{
        if(this.mazo.count()==0){
            reshuffleMazo()
        }
        return this.mazo.removeFirst()
    }

    fun newCartaMedio(carta:Carta){
        this.cartaMedio = carta
    }

    fun addCementerio(carta:Carta){
        this.cementerio.add(carta)
    }

    fun reshuffleMazo(){
        this.mazo = this.cementerio
        this.cementerio.clear()
        this.mazo.shuffle(Random(666))
    }
}