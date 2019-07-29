package com.lannix.netfilmdata.stuff.recycleView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.lannix.netfilmdata.R

import java.util.ArrayList

class MyRecyclerViewAdapter(context: Context, private val data: ArrayList<ListObject>) : RecyclerView.Adapter<MyRecyclerViewAdapter.MyRecycleViewHolder>() {

    private val inflater: LayoutInflater

    init {
        inflater = LayoutInflater.from(context)
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRecycleViewHolder {
        val view = inflater.inflate(R.layout.recycle_list_object, parent, false)
        return MyRecycleViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyRecycleViewHolder, position: Int) {
        holder.fill(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class MyRecycleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val topicTextView: TextView
        val informationTextView: TextView
        val checkBox: CheckBox

        init {
            topicTextView = itemView.findViewById(R.id.TopicTextView)
            informationTextView = itemView.findViewById(R.id.InformationTextView)
            checkBox = itemView.findViewById(R.id.CheckBox)
        }

        fun fill(listObject: ListObject) {
            topicTextView.text = listObject.topicText
            informationTextView.text = listObject.informationText
        }
    }
}
