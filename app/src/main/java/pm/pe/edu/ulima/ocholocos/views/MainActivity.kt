package pm.pe.edu.ulima.ocholocos.views

import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import pm.pe.edu.ulima.ocholocos.R


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var arrayCartas01:ArrayAdapter<Int>
        val numeros01 = mutableListOf(1,2,3,4)

        var arrayCartas02:ArrayAdapter<Int>
        val numeros02 = mutableListOf(5,6,7,8)

        var arrayCartas03:ArrayAdapter<Int>
        val numeros03 = mutableListOf(9,10,11,12)

        val lvP01 = findViewById<ListView>(R.id.lvP01)
        val lvP02 = findViewById<ListView>(R.id.lvP02)
        val lvP03 = findViewById<ListView>(R.id.lvP03)

        arrayCartas01 = ArrayAdapter(this, android.R.layout.simple_list_item_1, numeros01)
        lvP01.adapter = arrayCartas01
        arrayCartas02 = ArrayAdapter(this, android.R.layout.simple_list_item_1, numeros02)
        lvP02.adapter = arrayCartas02
        arrayCartas03 = ArrayAdapter(this, android.R.layout.simple_list_item_1, numeros03)
        lvP03.adapter = arrayCartas03



    }

}