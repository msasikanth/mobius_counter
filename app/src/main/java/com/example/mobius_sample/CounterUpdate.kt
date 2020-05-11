package com.example.mobius_sample

import com.spotify.mobius.Next
import com.spotify.mobius.Next.next
import com.spotify.mobius.Update

class CounterUpdate : Update<CounterModel, CounterEvent, Nothing> {
    override fun update(model: CounterModel, event: CounterEvent): Next<CounterModel, Nothing> {
        return next(model.increment())
    }
}
