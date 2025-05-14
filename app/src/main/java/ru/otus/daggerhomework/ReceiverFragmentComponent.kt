package ru.otus.daggerhomework

import android.content.Context
import dagger.Component

@ProducerScope
@Component(dependencies = [ApplicationComponent::class, MainActivityComponent::class], modules = [ReceiverFragmentModule::class])
interface ReceiverFragmentComponent {

    @Component.Factory
    interface Factory {
        fun create(applicationComponent: ApplicationComponent, mainActivityComponent: MainActivityComponent): ReceiverFragmentComponent
    }

    fun viewModelFactory(): ReceiverViewModel.Factory
}