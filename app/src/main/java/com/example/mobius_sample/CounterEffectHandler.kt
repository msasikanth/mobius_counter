package com.example.mobius_sample

import com.spotify.mobius.Connectable
import com.spotify.mobius.Connection
import com.spotify.mobius.functions.Consumer

class CounterEffectHandler : Connectable<Nothing, CounterEvent> {
    override fun connect(output: Consumer<CounterEvent>): Connection<Nothing> {
        return object : Connection<Nothing> {
            override fun accept(value: Nothing) {

            }

            override fun dispose() {

            }
        }
    }
}
