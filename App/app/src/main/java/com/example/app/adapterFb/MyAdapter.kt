package com.example.app.adapterFb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R
import com.example.app.modelsFb.User

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private val userList = ArrayList<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_astronaut, parent, false
        )

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = userList[position]

        holder.craft.text = currentitem.craft

        holder.name.text = currentitem.name
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun updateUserList(userList: List<User>){
        this.userList.clear()
        this.userList.addAll(userList)
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val name: TextView = itemView.findViewById(R.id.astronaut)

        val craft: TextView = itemView.findViewById(R.id.astronaut_craft)

    }

}