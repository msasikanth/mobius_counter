package com.example.mobius_sample

sealed class CounterEvent

object Increment : CounterEvent()

object Decrement : CounterEvent()
