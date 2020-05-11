package com.example.mobius_sample

import com.spotify.mobius.test.NextMatchers.hasModel
import com.spotify.mobius.test.NextMatchers.hasNoEffects
import com.spotify.mobius.test.UpdateSpec
import com.spotify.mobius.test.UpdateSpec.assertThatNext
import org.junit.Test

class CounterUpdateTest {

    private val updateSpec = UpdateSpec(CounterUpdate())
    private val defaultModel = CounterModel.default()

    @Test
    fun `whenever increment is clicked, then increment the value`() {
        updateSpec
            .given(defaultModel)
            .whenEvent(Increment)
            .then(
                assertThatNext(
                    hasModel(defaultModel.increment()),
                    hasNoEffects()
                )
            )
    }

    @Test
    fun `whenever decrement is clicked, then decrement the value`() {
        updateSpec
            .given(defaultModel)
            .whenEvent(Decrement)
            .then(
                assertThatNext(
                    hasModel(defaultModel.decrement()),
                    hasNoEffects()
                )
            )
    }
}
