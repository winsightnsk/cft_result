package com.example.cft_vladimir

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cft_vladimir.roompak.Hist

class HistAdapter (private val hists : List<List<String>>) : RecyclerView.Adapter<HistHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistHolder {
        val context  = parent.context
        val inflater = LayoutInflater.from(context)
        val view     = inflater.inflate(R.layout.dialog_hist_item, parent, false)
        return HistHolder(view)
    }

    override fun getItemCount(): Int {
        return hists.size
    }

    override fun onBindViewHolder(holder: HistHolder, position: Int) {
        val hist = hists[position]
        holder.bind(hist)
    }
}