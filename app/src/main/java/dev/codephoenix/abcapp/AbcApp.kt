package dev.codephoenix.abcapp
import android.app.Application
import dev.codephoenix.abcapp.di.learningElementsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AbcApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AbcApp)
            modules(learningElementsModule)
        }
    }
}