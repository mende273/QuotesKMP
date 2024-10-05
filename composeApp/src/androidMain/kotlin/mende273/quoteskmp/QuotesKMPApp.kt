package mende273.quoteskmp

import android.app.Application
import mende273.quoteskmp.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent

class QuotesKMPApp : Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger()
            androidContext(this@QuotesKMPApp)
        }
    }
}