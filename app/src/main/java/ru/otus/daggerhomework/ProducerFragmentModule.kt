package ru.otus.daggerhomework

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Named

@Module
interface ProducerFragmentModule {

    @ProducerScope
    @Binds
    fun bindColorGenerator(colorGenerator: ColorGeneratorImpl): ColorGenerator

    companion object {
        @ProducerScope
        @Provides
        fun provideViewModelFactory(
            colorGenerator: ColorGenerator,
            @ActivityContext context: Context,
            events: MutableStateFlow<Event>
        ) = ProducerViewModel.Factory(colorGenerator, context, events)
    }

}