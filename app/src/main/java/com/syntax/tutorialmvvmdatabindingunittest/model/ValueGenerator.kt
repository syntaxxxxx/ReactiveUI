package com.syntax.tutorialmvvmdatabindingunittest.model

class ValueGenerator {
    fun generateAllValue(valueSpinner: ValueSpinner, name: String = ""): Value {
        val hasil = 1 * valueSpinner.valueA +
                2 * valueSpinner.valueB +
                3 * valueSpinner.valueC
        return Value(name, valueSpinner, hasil)
    }
}