package com.example.sensor;

abstract class MeasurableSensor(
    protected val sensorType:Int
) {

    protected var onSensorValuesChanged:((List<Float>)->Unit)?=null
    abstract val doesSensorExist:Boolean
    abstract fun stopListening();
    abstract fun startListening();


    fun setOnSensorValuesChangedListener(listener:(List<Float>)->Unit){
        onSensorValuesChanged=listener
    }
}
