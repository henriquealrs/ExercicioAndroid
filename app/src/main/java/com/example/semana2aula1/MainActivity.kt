package com.example.semana2aula1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val kotlin = ProgrammingLanguage(R.drawable.ic_developer_board, "Kotlin", "apqkwnewoq",2010 )

        val items = listOf(kotlin, kotlin)

        val adapter = ProgrammingLanguageAdapter(items)
        recyclerView.adapter = adapter
    }
}
