package ma.mohamed.codingchallenge.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import ma.mohamed.codingchallenge.data.datasource.ReposDataSourceFactory
import ma.mohamed.codingchallenge.data.model.LoadingState
import ma.mohamed.codingchallenge.domain.entity.RepoEntity
import ma.mohamed.codingchallenge.domain.usecase.GetReposUseCase
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getReposUseCase: GetReposUseCase
) : ViewModel() {

    private val dataSourceFactory = ReposDataSourceFactory(getReposUseCase, getLastMonthDate())

    val repos: LiveData<PagedList<RepoEntity>>
    val loadingState: LiveData<LoadingState> = Transformations.switchMap(dataSourceFactory.dataSource) {
        it.loadingState
    }

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(30)
            .build()

        repos = LivePagedListBuilder<Int, RepoEntity>(dataSourceFactory, config).build()
    }

    fun refresh() = dataSourceFactory.dataSource.value!!.invalidate()

    fun retry() = dataSourceFactory.dataSource.value!!.retry()

    private fun getLastMonthDate(): String {
        val dateFormatter = SimpleDateFormat("YYYY-MM-DD", Locale.getDefault())
        val calendar = GregorianCalendar().apply {
            time = Date()
            add(Calendar.DAY_OF_MONTH, -30) // minus 30 days from today
        }
        return dateFormatter.format(calendar.time)
    }

    override fun onCleared() {
        getReposUseCase.dispose()
        super.onCleared()
    }
}