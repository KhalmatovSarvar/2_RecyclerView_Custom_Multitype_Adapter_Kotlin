package com.example.a2_recyclerview_custom_multitype_adapter_kotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a2_recyclerview_custom_multitype_adapter_kotlin.R
import com.example.a2_recyclerview_custom_multitype_adapter_kotlin.moel.Member


class CustomAdapter(val members:List<Member>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_AVAILABLE_YES = 0
    private val TYPE_AVAILABLE_NO = 1

    override fun getItemViewType(position: Int): Int {
        return if(members[position].available){
            TYPE_AVAILABLE_YES
    }else return TYPE_AVAILABLE_NO }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == TYPE_AVAILABLE_YES){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_custom_yes_view,parent,false)
            return CustomViewYesHolder(view)
        }

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_custom_no_view,parent,false)
        return CustomViewNoHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val member = members[position]

        if(holder is CustomViewYesHolder){
            holder.first_name.text = member.firstName
            holder.last_name.text = member.lastName
        }
        if(holder is CustomViewNoHolder){
            holder.first_name.text = "This firstName is not available"
            holder.last_name.text = "This lastName is not available"
        }
    }

    override fun getItemCount(): Int {
        return members.size
    }

}

class CustomViewNoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
     val first_name = itemView.findViewById<TextView>(R.id.firstName)
     val last_name = itemView.findViewById<TextView>(R.id.lastName)
}

class CustomViewYesHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val first_name = itemView.findViewById<TextView>(R.id.firstName)
    val last_name = itemView.findViewById<TextView>(R.id.lastName)
}
