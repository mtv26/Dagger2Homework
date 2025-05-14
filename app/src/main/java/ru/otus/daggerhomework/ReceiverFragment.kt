package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ReceiverFragment : Fragment() {

    private lateinit var frame: View
    lateinit var receiverFragmentComponent: ReceiverFragmentComponent
    val vm: ReceiverViewModel by viewModels {
        receiverFragmentComponent.viewModelFactory()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val appComponent = (context.applicationContext as App).appComponent
        val activityComponent = (this.activity as MainActivity).activityComponent
        receiverFragmentComponent = DaggerReceiverFragmentComponent
            .factory()
            .create(appComponent, activityComponent)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                vm.events.collectLatest {
                    if (it is Event.Update) {
                        vm.observeColors()
                        populateColor(it.color)
                    }
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_receiver, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frame = view.findViewById(R.id.frame)
    }

    fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}