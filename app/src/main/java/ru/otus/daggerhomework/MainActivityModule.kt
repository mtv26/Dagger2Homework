package ru.otus.daggerhomework

import android.content.Context
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Named

@Module
class MainActivityModule {

    @MainActivityScope
    @Provides
    fun providesEvents(): MutableStateFlow<Event> = MutableStateFlow(Event.Init)
}