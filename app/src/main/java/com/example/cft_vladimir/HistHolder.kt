package com.example.cft_vladimir

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cft_vladimir.roompak.Hist

class HistHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(hist: Hist) {
        title.text    = hist.binNum
    }

    var title:  TextView  = itemView.findViewById(R.id.dhist)
}