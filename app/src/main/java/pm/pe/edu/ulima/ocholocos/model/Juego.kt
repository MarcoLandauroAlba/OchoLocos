package pm.pe.edu.ulima.ocholocos.model

class Juego {
    private var mesa : Mesa = Mesa()
    private var jugadores : MutableList<Player> = mutableListOf()
    private var acumulado : Int = 0
    private var turno : Int = 0

    constructor(nombre1 : String, nombre2 : String,nombre3 : String){
        this.jugadores.add(Player(nombre1,1))
        this.jugadores.add(Player(nombre1,2))
        this.jugadores.add(Player(nombre1,3))
    }
}