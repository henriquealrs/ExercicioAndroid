package com.henriquealrs.android.semana3_aula2

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class Game (val name: String,
                 val launchYear: Int,
                 val imageUrl: String,
                 rating: Double) : BaseObservable() {



        @get:Bindable
        var rating by bindable(rating, BR.rating)
//        set(value) {
//            if(field != value) {
//                field = value
//                notifyPropertyChanged(BR.rating)
//            }
//        }
}
