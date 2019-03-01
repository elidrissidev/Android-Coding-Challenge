package ma.mohamed.codingchallenge.data.datasource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import ma.mohamed.codingchallenge.domain.entity.RepoEntity
import ma.mohamed.codingchallenge.domain.usecase.GetReposUseCase

class ReposDataSourceFactory(
    private val getReposUseCase: GetReposUseCase,
    private val startDate: String
) : DataSource.Factory<Int, RepoEntity>() {

    private val _dataSource = MutableLiveData<ReposDataSource>()
    val dataSource: LiveData<ReposDataSource>
        get() = _dataSource

    override fun create(): DataSource<Int, RepoEntity> {
        val source = ReposDataSource(getReposUseCase, startDate)
        _dataSource.postValue(source)
        return source
    }
}