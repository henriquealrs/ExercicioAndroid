package com.henriquealrs.android.semana3_aula4.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.henriquealrs.android.semana3_aula4.dao.WordDao
import com.henriquealrs.android.semana3_aula4.db.WordRoomDatabase
import com.henriquealrs.android.semana3_aula4.entities.Word
import org.jetbrains.anko.doAsync

class WordRepository(application: Application) {

    private val wordDao: WordDao

    val allWords: LiveData<List<Word>>

    init {
        val db = WordRoomDatabase.getDatabase(application)
        wordDao = db.wordDao()
        allWords = wordDao.getAllWords()
    }

    fun insert(word: Word) {
        doAsync{
            wordDao.insert(word)
        }
    }
}