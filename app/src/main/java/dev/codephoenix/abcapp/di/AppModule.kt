package dev.codephoenix.abcapp.di

import dagger.Module
import dagger.Provides
import dev.codephoenix.abcapp.MyApp
import javax.inject.Singleton

@Module
class AppModule(val app: MyApp) {
    @Provides
    @Singleton
    fun provideApp() = app
}