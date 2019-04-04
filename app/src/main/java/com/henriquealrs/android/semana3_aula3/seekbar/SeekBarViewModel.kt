package com.henriquealrs.android.semana3_aula3.seekbar

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SeekBarViewModel : ViewModel() {

    val seekBarValue = MutableLiveData<Int>()

}