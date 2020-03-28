package com.devproject.miguelfagundez.sortapp_kotlin.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devproject.miguelfagundez.sortapp_kotlin.R
import com.devproject.miguelfagundez.sortapp_kotlin.model.SortModel

/********************************************
 * SortAdapter - Base Adapter
 * Adapter that implements RecyclerView methods
 * SortedList methods are implemented also
 * @author: Miguel Fagundez
 * @date: March 27th, 2020
 * @version: 1.0
 * *******************************************/
class SortAdapter(var isAscending : Boolean) : RecyclerView.Adapter<SortAdapter.ViewHolder>() {

    var numberOfBlocks = mutableListOf<SortModel>()

    // Populate the MutableList
    fun createBlocks(list : MutableList<SortModel>?){
        val size = list?.size?:0
        for(i in 0..size-1){
            list?.let { mutableList ->
                numberOfBlocks?.add(mutableList.get(i))
            }
        }
        // Sorting the list
        when (isAscending){
            true -> numberOfBlocks.sortBy { it.name }
            else -> numberOfBlocks.sortByDescending { it.name }
        }
    }

    fun dataHasChanged(){
        notifyDataSetChanged()
    }

    //***************************************************
    // Recycler View methods
    //***************************************************
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_model, parent, false)
        return ViewHolder(view)
    }

    // Returning number of items
    override fun getItemCount() = numberOfBlocks?.size?:0

    // Connecting views with data
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            tvName.text = numberOfBlocks?.get(position)?.name
            tvNumberOfPeople.text = numberOfBlocks?.get(position)?.numberOfFriends.toString()
            tvMessage.text = numberOfBlocks?.get(position)?.numberOfMessages.toString()
        }
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var tvName : TextView = itemView.findViewById(R.id.tvName)
        var tvNumberOfPeople = itemView.findViewById<TextView>(R.id.tvNumberPeople)
        var tvMessage = itemView.findViewById(R.id.tvMessages) as TextView
    }
}