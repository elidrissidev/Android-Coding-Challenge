package ma.mohamed.codingchallenge.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ma.mohamed.codingchallenge.ui.main.MainActivity
import ma.mohamed.codingchallenge.di.annotations.ActivityScoped

@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity
}