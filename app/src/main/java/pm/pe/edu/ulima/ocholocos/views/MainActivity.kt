package pm.pe.edu.ulima.ocholocos.views

import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import pm.pe.edu.ulima.ocholocos.Adapters.CartaAdapter
import pm.pe.edu.ulima.ocholocos.R
import pm.pe.edu.ulima.ocholocos.model.Carta
import pm.pe.edu.ulima.ocholocos.model.Juego


class MainActivity : AppCompatActivity() {

    private var mBotonPasarJugador1 : Button? = null
    private lateinit var mJuego : Juego
    private var mtextoTemp : TextView? = null
    private var mLanzaronJ : Boolean = false
    private var cartaAux : Carta? = null
    private var mBotonRobar1 : Button? = null
    private var mPuedeRobar : Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mJuego = Juego()
        mBotonPasarJugador1 = findViewById(R.id.pasar1)
        mBotonRobar1 = findViewById(R.id.robarBut)

        mtextoTemp = findViewById(R.id.turnoTemp)
        mtextoTemp!!.text = "Turno :"+mJuego.turno.toString()+"\nMano:" + mJuego.jugadores[mJuego.turno-1].obtenerNumeroMano().toString()+"\nCarta de medio: "+mJuego.mesa.cartaMedio.toString()+"\nMazo: "+mJuego.mesa.mazo.count()

        mBotonPasarJugador1!!.setOnClickListener{
            if(mJuego.turno!=1){
                Log.i("dad","No es su turno")
            }else{
                mJuego.sigTurno(mLanzaronJ)
                mtextoTemp!!.text = mJuego.turno.toString()
                mPuedeRobar = true
            }
        }

        mBotonRobar1!!.setOnClickListener{
            if(mPuedeRobar){
                robarCartas(mJuego.turno)
                mtextoTemp!!.text = "Turno :"+mJuego.turno.toString()+"\nMano:" + mJuego.jugadores[mJuego.turno-1].obtenerNumeroMano().toString()+"\nCarta de medio: "+mJuego.mesa.cartaMedio.toString()+"\nMazo: "+mJuego.mesa.mazo.count()
            }else{
                Log.i("da","No puede robar")
            }
        }




















        //MARCO>
        val carta01 = Carta(4,1)
        val carta02 = Carta(1,2)
        val carta03 = Carta(2,3)
        val carta04 = Carta(3,4)
        val carta05 = Carta(4,5)
        val carta06 = Carta(1,6)
        val carta07 = Carta(2,7)
        val carta08 = Carta(3,8)
        val carta11 = Carta(4,9)
        val carta12 = Carta(1,1)
        val carta13 = Carta(2,2)
        val carta14 = Carta(3,3)
        val carta15 = Carta(4,4)
        val carta16 = Carta(1,5)
        val carta17 = Carta(2,6)
        val carta18 = Carta(3,7)

        val listaCartitas : List<Carta> = listOf(
            carta01,carta02,carta03,carta04,carta05,carta06,
            carta07,carta08,carta11,carta12,carta13,carta14,
            carta15,carta16,carta17,carta18
        )


        // ADAPTADOR DE CARTAS LISTAS 01
        val adapterCartasLista01 = CartaAdapter(this, listaCartitas)

        val lv_ListaCartas01 = findViewById<ListView>(R.id.lv_ListaCartas01)
        lv_ListaCartas01.adapter = adapterCartasLista01

        lv_ListaCartas01.setOnItemClickListener{ parent, view, position, id ->
            Toast
                .makeText(
                    this@MainActivity,
                    "La carta es el ${listaCartitas[position].num} de palo ${listaCartitas[position].palo}",
                    Toast.LENGTH_SHORT)
                .show()
        }



        // ADAPTADOR DE CARTAS LISTAS 02
        val adapterCartasLista02 = CartaAdapter(this, listaCartitas)

        val lv_ListaCartas02 = findViewById<ListView>(R.id.lv_ListaCartas02)
        lv_ListaCartas02.adapter = adapterCartasLista02

        lv_ListaCartas02.setOnItemClickListener{ parent, view, position, id ->
            Toast
                .makeText(
                    this@MainActivity,
                    "La carta es el ${listaCartitas[position].num} de palo ${listaCartitas[position].palo}",
                    Toast.LENGTH_SHORT)
                .show()
        }







    }
    fun robarCartas(jugador : Int,acumulado : Int = mJuego.acumulado){
        if(mJuego.mesa.mazo.count()==0){
            mJuego.mesa.reshuffleMazo()
        }
        if(acumulado == 0 ){
            mJuego.jugadores[jugador-1].addCardHand(mJuego.mesa.robarCarta())
            mPuedeRobar = false
        }else{
            for (x in 1..acumulado){
                mJuego.jugadores[jugador-1].addCardHand(mJuego.mesa.robarCarta())
            }
            mPuedeRobar = false
        }
    }

}