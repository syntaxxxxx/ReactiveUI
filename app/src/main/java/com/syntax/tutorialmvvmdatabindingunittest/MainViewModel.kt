package com.syntax.tutorialmvvmdatabindingunittest

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.syntax.tutorialmvvmdatabindingunittest.model.*

class MainViewModel(private val valueGenerator: ValueGenerator = ValueGenerator()) : ViewModel() {

    var name = ""
    var valueA: Int = 0
    var valueB: Int = 0
    var valueC: Int = 0

    lateinit var values: Value
    val valueLiveData = MutableLiveData<Value>()
    val saveLiveData = MutableLiveData<Boolean>()

    fun getAllValue(): LiveData<Value> {
        return valueLiveData
    }

    fun getSaveLiveData(): LiveData<Boolean> {
        return saveLiveData
    }

    fun updateValue() {
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

    fun showToView() {
    }
}