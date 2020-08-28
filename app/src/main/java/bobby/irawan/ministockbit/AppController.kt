package bobby.irawan.ministockbit

import android.app.Application
import bobby.irawan.ministockbit.di.remoteModule
import bobby.irawan.ministockbit.domain.di.dataModule
import bobby.irawan.ministockbit.domain.di.domainModule
import bobby.irawan.ministockbit.domain.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

/**
 * Created by bobbyirawan09 on 25/08/20.
 */
class AppController: Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        startKoin{
            androidLogger()
            androidContext(this@AppController)
            modules(
                dataModule,
                remoteModule,
                domainModule,
                presentationModule
            )
        }
    }

    companion object {
        lateinit var instance: AppController
    }

}