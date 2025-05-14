package ru.otus.daggerhomework

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Named

@Module
class ReceiverFragmentModule {

    @ProducerScope
    @Provides
    fun provideViewModelFactory(
        @ApplicationContext context: Context,
        events: MutableStateFlow<Event>
    ) = ReceiverViewModel.Factory(context, events)

}