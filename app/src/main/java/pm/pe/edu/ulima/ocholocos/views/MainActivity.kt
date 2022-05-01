package pm.pe.edu.ulima.ocholocos.views

import android.os.Bundle
import android.os.PersistableBundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
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