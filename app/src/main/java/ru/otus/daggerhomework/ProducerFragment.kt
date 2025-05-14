package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider

class ProducerFragment : Fragment() {

    lateinit var producerFragmentComponent: ProducerFragmentComponent
    val vm: ProducerViewModel by viewModels {
        producerFragmentComponent.viewModelFactory()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val appComponent = (context.applicationContext as App).appComponent
        val activityComponent = (this.activity as MainActivity).activityComponent
        producerFragmentComponent = DaggerProducerFragmentComponent
            .factory()
            .create(appComponent, activityComponent)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_producer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            vm.generateColor()
            //отправить результат через flow в другой фрагмент
        }
    }
}