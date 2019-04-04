package com.henriquealrs.android.semana3_aula3.chronometervm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import androidx.lifecycle.ViewModelProviders
import com.henriquealrs.android.semana3_aula3.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(ChronometerViewModel::class.java)

        if(viewModel.startTime == 0L) {
            viewModel.startTime = SystemClock.elapsedRealtime()
        }

        chronometer.base = viewModel.startTime
        chronometer.start()
    }
}
