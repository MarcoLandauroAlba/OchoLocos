package pm.pe.edu.ulima.ocholocos.model

class Juego {
    var mesa : Mesa = Mesa()
    var jugadores : MutableList<Player> = mutableListOf()
    var acumulado : Int = 0
    var turno : Int = 0

    constructor(nombre1 : String="Jugador 1", nombre2 : String="Jugador 2",nombre3 : String="Jugador 3"){
        this.jugadores.add(Player(nombre1,1))
        this.jugadores.add(Player(nombre2,2))
        this.jugadores.add(Player(nombre3,3))
        this.turno = (1..3).random()
        repartirInicial()
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
        this.turno +=1
        if (this.turno == 4){
            this.turno = 1
        }
        if(j){
            this.turno +=1
        }
        if (this.turno == 4) {
            this.turno = 1
        }
    }

    fun aumentarAcum (){
        this.acumulado +=3
    }
}