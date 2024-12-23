package com.demo.margaritamvvmkoinflow_14_08_2024.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.demo.margaritamvvmkoinflow_14_08_2024.R
import com.demo.margaritamvvmkoinflow_14_08_2024.model.Drinks

class MargaritaAdapter(private val drinks:List<Drinks>):RecyclerView.Adapter<MargaritaAdapter.MyViewHolder>(){

    class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        var id = itemView.findViewById<TextView>(R.id.txt_id)
        var name = itemView.findViewById<TextView>(R.id.txt_name)
        var image = itemView.findViewById<ImageView>(R.id.image_view)

        fun bindView(drinks: Drinks){
            id.text = drinks.idDrink
            name.text = drinks.strDrink
            val url = drinks.strDrinkThumb

            image.load(url)
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): MargaritaAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.margarita_items,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MargaritaAdapter.MyViewHolder, position: Int) {
        holder.bindView(drinks[position])
    }

    override fun getItemCount(): Int {
        return drinks.size
    }
}