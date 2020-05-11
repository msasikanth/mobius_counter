package com.example.mobius_sample

import com.spotify.mobius.test.NextMatchers.hasModel
import com.spotify.mobius.test.NextMatchers.hasNoEffects
import com.spotify.mobius.test.UpdateSpec
import com.spotify.mobius.test.UpdateSpec.assertThatNext
import org.junit.Test

class CounterUpdateTest {

    @Test
    fun `whenever increment is clicked, then increment the value`() {
        val updateSpec = UpdateSpec(CounterUpdate())
        val defaultModel = CounterModel.default()

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
}
