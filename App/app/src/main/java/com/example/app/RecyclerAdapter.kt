package com.example.app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app.databinding.FragmentHomeBinding
import com.example.app.model.Astronaut

class RecyclerAdapter (private var astronautNames: List<String>, private var astronautCrafts: List<String>):
RecyclerView.Adapter<RecyclerAdapter.ViewHodler>()
{
    init {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHodler {

        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.item_astronaut, parent, false)
        return ViewHodler(v)
    }

    override fun onBindViewHolder(holder: ViewHodler, position: Int) {
        holder.itemTitle.text = astronautNames[position]
        holder.itemCraft.text = astronautCrafts[position]
    }

    override fun getItemCount(): Int {
        return astronautNames.size
    }

    inner class ViewHodler(itemView: View) : RecyclerView.ViewHolder(itemView){
        val itemTitle: TextView = itemView.findViewById(R.id.astronaut)
        val itemCraft: TextView = itemView.findViewById(R.id.astronaut_craft)

        init {

        }

    }


}