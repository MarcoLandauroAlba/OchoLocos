package pm.pe.edu.ulima.ocholocos.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import pm.pe.edu.ulima.ocholocos.R
import kotlin.math.min

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val (height, width) = resources.displayMetrics.run { heightPixels/density to widthPixels/density }
        val min = min(height,width)


        val textito : TextView = findViewById(R.id.textito)
        textito.text = min.toString()

        val lvP01 : ListView = findViewById(R.id.lvP01)
        lvP01.layoutParams.width = (2/3*min).toInt()
        val lvP02 : ListView = findViewById(R.id.lvP02)
        lvP02.layoutParams.width = (2/3*min).toInt()
    }
}