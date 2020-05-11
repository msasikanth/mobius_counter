package com.example.mobius_sample

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.spotify.mobius.Connection
import com.spotify.mobius.Mobius
import com.spotify.mobius.MobiusLoop
import com.spotify.mobius.android.MobiusAndroid
import kotlinx.android.synthetic.main.fragment_counter.*

class CounterFragment : Fragment(R.layout.fragment_counter) {

    private lateinit var controller: MobiusLoop.Controller<CounterModel, CounterEvent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        controller = MobiusAndroid.controller(
            Mobius.loop(
                CounterUpdate(),
                CounterEffectHandler()
            ),
            CounterModel.default()
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        controller.connect { output ->
            object : Connection<CounterModel> {
                override fun accept(model: CounterModel) {
                    counterValue.text = model.value.toString()

                    incrementButton.setOnClickListener {
                        output.accept(Increment)
                    }

                    decrementButton.setOnClickListener {
                        output.accept(Decrement)
                    }
                }

                override fun dispose() {
                    incrementButton.setOnClickListener(null)
                    decrementButton.setOnClickListener(null)
                }
            }
        }

        if (savedInstanceState != null) {
            controller.replaceModel(savedInstanceState.getParcelable("counter")!!)
        }
    }

    override fun onResume() {
        super.onResume()
        controller.start()
    }

    override fun onPause() {
        super.onPause()
        controller.stop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        controller.disconnect()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable("counter", controller.model)
    }
}
