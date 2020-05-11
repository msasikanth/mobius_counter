package com.example.mobius_sample

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CounterModel(
    val value: Int
) : Parcelable {

    companion object {
        fun default() = CounterModel(value = 0)
    }

    fun increment() = copy(value = value + 1)
    fun decrement() = copy(value = value - 1)
}
