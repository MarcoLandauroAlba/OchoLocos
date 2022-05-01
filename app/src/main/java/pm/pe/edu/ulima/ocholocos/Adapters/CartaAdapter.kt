package pm.pe.edu.ulima.ocholocos.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.view_carta.view.*
import pm.pe.edu.ulima.ocholocos.R
import pm.pe.edu.ulima.ocholocos.model.Carta

class CartaAdapter(private val mContext : Context, private val listaCartas : List<Carta>) : ArrayAdapter<Carta>(mContext, 0, listaCartas) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.view_carta, parent, false)

        val carta = listaCartas[position]

        layout.numero.text = "${carta.num}"
        layout.palo.text = "${carta.palo}"

        return layout
    }

}