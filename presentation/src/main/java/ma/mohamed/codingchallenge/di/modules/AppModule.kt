package ma.mohamed.codingchallenge.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import ma.mohamed.codingchallenge.App
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideApplicationContext(app: App): Context = app.applicationContext
}