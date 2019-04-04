package com.henriquealrs.android.semana3_aula3.chronometerld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.henriquealrs.android.semana3_aula3.R
import kotlinx.android.synthetic.main.activity_live_data.*

class LiveDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)

        val liveDataViewModel = ViewModelProviders.of(this).get(LiveDataViewModel::class.java)

        liveDataViewModel.elapsedTime.observe(this, Observer {
            textView.text  = "Elapset time: ${it}"
        })
    }
}
