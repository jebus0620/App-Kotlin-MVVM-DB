package com.project.bcp.appexchangerate.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.bcp.appexchangerate.R
import com.project.bcp.appexchangerate.domain.model.Currency
import kotlin.collections.ArrayList

class CurrencyAdapter(

    var list: ArrayList<Currency>,
    private var context: Context,
    private val itemCallback: (Currency) -> Unit) : RecyclerView.Adapter<CurrencyAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item, position, context)

        holder.itemView.setOnClickListener {
            itemCallback(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.row_currency, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tviCurrency: TextView = view.findViewById<TextView>(R.id.tviCurrency)
        val tviName: TextView = view.findViewById<TextView>(R.id.tviName)
        val iviLogo: ImageView = view.findViewById<ImageView>(R.id.iviLogo)

        fun bind(item: Currency, position: Int, context: Context) {

            tviName.text = item.component2()
            var image = 0
            when(item.component1()){
                1 -> image = R.drawable.ic_peru
                2 -> image = R.drawable.ic_european_union
                3 -> image = R.drawable.ic_united_states
                4 -> image = R.drawable.ic_japon
                5 -> image = R.drawable.ic_united_kingdom
                6 -> image = R.drawable.ic_switzerland
                7 -> image = R.drawable.ic_canada
            }

            iviLogo.setImageResource(image)
        }
    }

    fun setChangeList(list: ArrayList<Currency>){
        this.list = list
        notifyDataSetChanged()
    }
}