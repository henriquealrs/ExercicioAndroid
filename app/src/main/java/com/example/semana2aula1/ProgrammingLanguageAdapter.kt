package com.example.semana2aula1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.programming_language_item.view.*

class ProgrammingLanguageAdapter(val items: List<ProgrammingLanguage>,
                                 val listener: (ProgrammingLanguage)->Unit)
    : RecyclerView.Adapter<ProgrammingLanguageAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(
            item: ProgrammingLanguage,
            listener: (ProgrammingLanguage) -> Unit
        ) = with(itemView) {

            ivMain.setImageResource(item.imageResourceId)
            tvTitle.text = item.year.toString()
            tvTitle.text = item.name

            itemView.setOnClickListener {
                listener(item)
            }
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgrammingLanguageAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.programming_language_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = items.size


    override fun onBindViewHolder(holder: ProgrammingLanguageAdapter.ViewHolder, position: Int) {
        val item = items[position]
        holder.bindView(item, listener)
    }

}