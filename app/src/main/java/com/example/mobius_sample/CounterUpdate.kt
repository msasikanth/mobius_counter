package com.example.mobius_sample

import com.spotify.mobius.Next
import com.spotify.mobius.Next.next
import com.spotify.mobius.Next.noChange
import com.spotify.mobius.Update

class CounterUpdate : Update<CounterModel, CounterEvent, Nothing> {
    override fun update(model: CounterModel, event: CounterEvent): Next<CounterModel, Nothing> {
        return when (event) {
            Increment -> next(model.increment())
            Decrement -> decrementValue(model)
        }
    }

    private fun decrementValue(model: CounterModel): Next<CounterModel, Nothing> {
        val decrementedModel = model.decrement()
        return if (decrementedModel.value < 0) {
            noChange()
        } else {
            next(model.decrement())
        }
    }
}
