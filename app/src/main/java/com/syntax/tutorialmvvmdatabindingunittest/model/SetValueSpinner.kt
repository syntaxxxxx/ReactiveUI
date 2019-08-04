package com.syntax.tutorialmvvmdatabindingunittest.model

object SetValueSpinner {

    val VALUE_A: List<AttributeValue> by lazy {
        val setValue = mutableListOf<AttributeValue>()
        setValue.add(AttributeValue())
        setValue.add(AttributeValue(1))
        setValue.add(AttributeValue(2))
        setValue.add(AttributeValue(3))
        setValue
    }

    val VALUE_B: List<AttributeValue> by lazy {
        val setValue = mutableListOf<AttributeValue>()
        setValue.add(AttributeValue())
        setValue.add(AttributeValue(1))
        setValue.add(AttributeValue(2))
        setValue.add(AttributeValue(3))
        setValue
    }

    val VALUE_C: List<AttributeValue> by lazy {
        val setValue = mutableListOf<AttributeValue>()
        setValue.add(AttributeValue())
        setValue.add(AttributeValue(1))
        setValue.add(AttributeValue(2))
        setValue.add(AttributeValue(3))
        setValue
    }
}