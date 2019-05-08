package dev.codephoenix.abcapp.di

import dev.codephoenix.abcapp.data.LearningElements
import org.koin.dsl.module

val learningElementsModule = module {

    single { LearningElements() }

}