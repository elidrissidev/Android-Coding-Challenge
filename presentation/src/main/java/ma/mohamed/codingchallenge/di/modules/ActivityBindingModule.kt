package ma.mohamed.codingchallenge.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ma.mohamed.codingchallenge.ui.main.MainActivity
import ma.mohamed.codingchallenge.di.annotations.ActivityScoped
import ma.mohamed.codingchallenge.ui.main.MainModule

@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun mainActivity(): MainActivity
}