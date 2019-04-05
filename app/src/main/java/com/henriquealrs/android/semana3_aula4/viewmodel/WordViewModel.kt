package com.henriquealrs.android.semana3_aula4.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.henriquealrs.android.semana3_aula4.entities.Word
import com.henriquealrs.android.semana3_aula4.repository.WordRepository

class WordViewModel(application: Application) : AndroidViewModel(application)
{
    private val repository = WordRepository(application)

    val allWords = repository.allWords

    fun insert(word: Word) {
        repository.insert(word)
    }
}