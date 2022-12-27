package com.example.cft_vladimir

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HistHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(hist: List<String>) {
        fieldDate.text = hist[0]
        fieldN.text    = hist[1]
    }

    private var fieldDate: TextView = itemView.findViewById(R.id.dhistt)
    private var fieldN   : TextView = itemView.findViewById(R.id.dhistn)
}