package ma.mohamed.codingchallenge.ui.main

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import ma.mohamed.codingchallenge.di.annotations.FragmentScoped
import ma.mohamed.codingchallenge.di.annotations.ViewModelKey

@Module
abstract class MainModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun mainFragment(): MainFragment

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}