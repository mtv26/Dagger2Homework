package ru.otus.daggerhomework

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import javax.inject.Named

@SuppressLint("StaticFieldLeak")
class ProducerViewModel(
    private val colorGenerator: ColorGenerator,
    private val context: Context,
    private val events: MutableStateFlow<Event>
): ViewModel() {

    fun generateColor() {
        if (context !is Activity) throw RuntimeException("Activity context is required")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
        events.tryEmit(Event.Update(colorGenerator.generateColor()))
    }

    @Suppress("UNCHECKED_CAST")
    class Factory(
        private val colorGenerator: ColorGenerator,
        private val context: Context,
        private val events: MutableStateFlow<Event>
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ProducerViewModel(colorGenerator, context, events) as T
        }
    }
}