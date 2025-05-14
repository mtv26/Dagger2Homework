package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Named

class ReceiverViewModel (
    private val context: Context,
    _events: MutableStateFlow<Event>
): ViewModel() {

    val events = _events.asStateFlow()

    fun observeColors() {
        if (context !is Application) throw RuntimeException("Application context is required")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
    }

    @Suppress("UNCHECKED_CAST")
    class Factory(
        private val context: Context,
        private val events: MutableStateFlow<Event>
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ReceiverViewModel(context, events) as T
        }
    }
}