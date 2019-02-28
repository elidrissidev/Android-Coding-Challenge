package ma.mohamed.codingchallenge

import com.squareup.leakcanary.LeakCanary
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import ma.mohamed.codingchallenge.di.DaggerAppComponent
import timber.log.Timber

/**
 * @author Mohamed ELIDRISSI
 */
class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }

    override fun onCreate() {
        super.onCreate()

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // Process dedicated to LeakCanary
            return
        }
        LeakCanary.install(this)

        Timber.plant(Timber.DebugTree())
    }
}