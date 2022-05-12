package com.example.sensor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val lightSensor: MeasurableSensor
) : ViewModel() {



    private val _isDark= MutableLiveData<Boolean>()
    val isDark: LiveData<Boolean>
        get() = _isDark


    init {
        lightSensor.startListening()
        lightSensor.setOnSensorValuesChangedListener { values ->
            val lux = values[0]
            if(lux<60f){
                _isDark.value=true
            }
        }
    }
}