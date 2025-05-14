package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Named

@MainActivityScope
@Component(modules = [MainActivityModule::class])
interface MainActivityComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance @ActivityContext context: Context): MainActivityComponent
    }

    fun events(): MutableStateFlow<Event>

    @get:ActivityContext
    val activityContext: Context
}