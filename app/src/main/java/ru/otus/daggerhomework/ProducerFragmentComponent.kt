package ru.otus.daggerhomework

import android.content.Context
import dagger.Component

@ProducerScope
@Component(dependencies = [ApplicationComponent::class, MainActivityComponent::class], modules = [ProducerFragmentModule::class])
interface ProducerFragmentComponent {

    @Component.Factory
    interface Factory {
        fun create(applicationComponent: ApplicationComponent, mainActivityComponent: MainActivityComponent): ProducerFragmentComponent
    }

    fun colorGenerator(): ColorGenerator

    fun viewModelFactory(): ProducerViewModel.Factory
}