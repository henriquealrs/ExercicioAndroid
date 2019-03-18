package com.example.semana2aula1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.programming_language_item.view.*

class ProgrammingLanguageAdapter(val items: List<ProgrammingLanguage>) : RecyclerView.Adapter<ProgrammingLanguageAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(item: ProgrammingLanguage) = with(itemView) {
//                ivMain.setImageResource(item.)
            ivMain.setImageResource(item.imageResourceId)
            tvTitle.text = item.year.toString()
            tvTitle.text = item.name
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgrammingLanguageAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.programming_language_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = items.size


    override fun onBindViewHolder(holder: ProgrammingLanguageAdapter.ViewHolder, position: Int) {
        val item = items[position]
        holder.bindView(item)
    }

}