package com.syntax.tutorialmvvmdatabindingunittest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.syntax.tutorialmvvmdatabindingunittest.model.*

class MainViewModel(private val valueGenerator: ValueGenerator = ValueGenerator()) : ViewModel() {

    var name: String = ""
    var valueA: Int = 0
    var valueB: Int = 0
    var valueC: Int = 0

    lateinit var values: Value
    val valueLiveData = MutableLiveData<Value>()

    fun getAllValue(): LiveData<Value> {
        return valueLiveData
    }

    fun updateValue() {
        val valueSpinner = ValueSpinner(valueA, valueB, valueC)
        values = valueGenerator.generateAllValue(valueSpinner, name)
        valueLiveData.postValue(values)
    }

    fun isSpinnerSelected(spinnerType: SpinnerType, position: Int) {
        when (spinnerType) {
            SpinnerType.VALUE_A ->
                valueA = SetValueSpinner.VALUE_A[position].value
            SpinnerType.VALUE_B ->
                valueB = SetValueSpinner.VALUE_B[position].value
            SpinnerType.VALUE_C ->
                valueC = SetValueSpinner.VALUE_C[position].value
        }
        updateValue()
    }
}