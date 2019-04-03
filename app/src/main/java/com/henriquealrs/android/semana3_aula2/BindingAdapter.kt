package com.henriquealrs.android.semana3_aula2

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso


object BindingAdapters {
    @JvmStatic
    @BindingAdapter("image")
    fun ImageView.loadImage(imageUrl: String?) {
        Picasso.get().load(imageUrl).into(this)
    }
}