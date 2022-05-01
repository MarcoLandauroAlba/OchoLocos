package pm.pe.edu.ulima.ocholocos.model

class Juego {
    var mesa : Mesa = Mesa()
    var jugadores : MutableList<Player> = mutableListOf()
    private var acumulado : Int = 0
    var turno : Int = 0

    constructor(nombre1 : String, nombre2 : String,nombre3 : String){
        this.jugadores.add(Player(nombre1,1))
        this.jugadores.add(Player(nombre2,2))
        this.jugadores.add(Player(nombre3,3))
        this.turno = (1..3).random()
    }

    fun repartirInicial (){
        for(i in 1..8){
            this.jugadores[0].addCardHand(this.mesa.mazo.removeFirst())
            this.jugadores[1].addCardHand(this.mesa.mazo.removeFirst())
            this.jugadores[2].addCardHand(this.mesa.mazo.removeFirst())
        }
        this.mesa.newCartaMedio(this.mesa.mazo.removeFirst())
    }

    fun sigTurno (j : Boolean = false){
        if (this.turno == 3){
            this.turno == 1
        }
        if(j){
            this.turno +=1
        }
        if (this.turno == 3) {
            this.turno == 1
        }
    }

    fun aumentarAcum (){
        this.acumulado +=3
    }
}