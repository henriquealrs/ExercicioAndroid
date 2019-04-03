package com.henriquealrs.android.semana3_aula2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.henriquealrs.android.semana3_aula2.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.reflect.KProperty

class MainActivity : AppCompatActivity() {

     val binding: ActivityMainBinding by SetContentView(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Modrreu
//        setContentView(R.layout.activity_main)

        //val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val game = Game(
            "AAAAAA", 1981,
            "https://www.tekimobile.com/wp-content/uploads/2019/01/melhores-encurtadores-de-url.jpeg",
            4.0
        )
        binding.game = game

        tvRating.setOnClickListener {
            game.rating = game.rating + 0.1
            Toast.makeText(this, "poapkds", Toast.LENGTH_LONG).show()
        }

    }
}

