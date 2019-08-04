package com.syntax.tutorialmvvmdatabindingunittest.model

data class Value(
    val name: String,
    val valueSpinner: ValueSpinner = ValueSpinner(),
    val hasil: Int = 0
)