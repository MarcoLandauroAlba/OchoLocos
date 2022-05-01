package pm.pe.edu.ulima.ocholocos.views

import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.ListView
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import pm.pe.edu.ulima.ocholocos.R


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        val displayMetrics: DisplayMetrics = this.resources.displayMetrics\





        val dpHeight = displayMetrics.heightPixels / displayMetrics.density
        val dpWidth = displayMetrics.widthPixels / displayMetrics.density




        val svP01 : ScrollView = findViewById(R.id.svP01)
        svP01.layoutParams.width = dpWidth.toInt()
        val svP02 : ScrollView = findViewById(R.id.svP02)
        svP02.layoutParams.width = dpWidth.toInt()
        val svP03 : ScrollView = findViewById(R.id.svP03)
        svP03.layoutParams.width = dpWidth.toInt()


        val lvP01 : ListView = findViewById(R.id.lvP01)

        val lvP02 : ListView = findViewById(R.id.lvP02)

        val lvP03 : ListView = findViewById(R.id.lvP03)


        val tvLetras = findViewById<TextView>(R.id.textito)
        tvLetras.text = dpWidth.toString()
    }

}