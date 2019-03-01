package ma.mohamed.codingchallenge.di

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ma.mohamed.codingchallenge.App
import ma.mohamed.codingchallenge.di.modules.*
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBindingModule::class,
        NetworkModule::class,
        RepositoryModule::class,
        ViewModelModule::class,
        UseCaseModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}