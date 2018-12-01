package com.example.vpb.pass

//import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.jetbrains.anko.find

class MyAdapter(private val entityList: ArrayList<Entity>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_layout, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: MyAdapter.ViewHolder, position: Int) {
        holder.bindItems(entityList[position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return entityList.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(entity: Entity){
            val textViewName = itemView.find<TextView>(R.id.textViewName)
            val textViewLogin  = itemView.find<TextView>(R.id.textViewLogin)
            val textViewPass  = itemView.find<TextView>(R.id.textViewPass)

            textViewName.text = entity.name
            textViewLogin.text = entity.login
            textViewPass.text = entity.pass

        }
    }
}