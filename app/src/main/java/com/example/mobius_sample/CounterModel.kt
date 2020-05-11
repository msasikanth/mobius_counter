package com.example.mobius_sample

data class CounterModel(
    val value: Int
) {

    companion object {
        fun default() = CounterModel(value = 0)
    }

    fun increment() = copy(value = value + 1)
    fun decrement() = copy(value = value - 1)
}
