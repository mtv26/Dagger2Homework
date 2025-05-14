package ru.otus.daggerhomework

import androidx.annotation.ColorInt

sealed interface Event {
    data object Init: Event
    data class Update(@ColorInt val color: Int): Event
}