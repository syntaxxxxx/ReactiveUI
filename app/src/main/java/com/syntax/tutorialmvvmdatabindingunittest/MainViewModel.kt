package com.syntax.tutorialmvvmdatabindingunittest

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.syntax.tutorialmvvmdatabindingunittest.model.*

class MainViewModel(private val valueGenerator: ValueGenerator = ValueGenerator()) : ViewModel() {

    var name = ObservableField<String>("")
    var valueA: Int = 0
    var valueB: Int = 0
    var valueC: Int = 0

    lateinit var values: Value
    val valueLiveData = MutableLiveData<Value>()
    val saveLiveData = MutableLiveData<Boolean>()

    // get all data value
    fun getAllValue(): LiveData<Value> {
        return valueLiveData
    }

    // save data if field is not empty
    fun getSaveLiveData(): LiveData<Boolean> {
        return saveLiveData
    }

    /**
     * update value realtime
     * */
    fun updateValue() {
        val valueSpinner = ValueSpinner(valueA, valueB, valueC)
        values = valueGenerator.generateAllValue(valueSpinner, name.get() ?: "")
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
        // update value when user interactions with spinner
        updateValue()
    }

    /**
     * cek if not empty & show data to view
     * call this function into your binding layout
     * event click button
     * */
    fun showToView() {
        return if (isNotEmptyField()) {
            // update value
            updateValue()
            saveLiveData.postValue(true)
        } else {
            saveLiveData.postValue(false)
        }
    }

    // cek is not empty field
    fun isNotEmptyField(): Boolean {
        val name = this.name.get()
        name?.let {
            return valueA != 0 && valueB != 0 && valueC != 0 &&
                    name.isNotEmpty()
        }
        return false
    }
}