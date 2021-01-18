package com.example.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.affirmations.model.Affirmation

//Adapter for the RecyclerView in Main. It displays Affirmation data object

class ItemAdapter(private val context: Context,
                  private val dataSet: List<Affirmation>)
    :RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){
    /*Provide a reference to the views for each data item. Complex data might need more than one
    view per item, and you provide access to all the views for a data item in a view holder.
    Each data item is an Affirmation obj.
    * */

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        //this create a new view
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }
    //return size
    override fun getItemCount(): Int = dataSet.size
    //replace content of a view. Invoked by the layout manager
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataSet[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)

        holder.imageView.setImageResource(item.imageResourceId)
    }
}