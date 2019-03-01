package ma.mohamed.codingchallenge.data.datasource

import androidx.lifecycle.LiveData
import androidx.paging.PageKeyedDataSource
import io.reactivex.rxkotlin.subscribeBy
import ma.mohamed.codingchallenge.data.extensions.mutableLiveDataOf
import ma.mohamed.codingchallenge.data.model.LoadingState
import ma.mohamed.codingchallenge.domain.entity.RepoEntity
import ma.mohamed.codingchallenge.domain.usecase.GetReposUseCase
import timber.log.Timber

class ReposDataSource(
    private val getReposUseCase: GetReposUseCase,
    private val startDate: String
) : PageKeyedDataSource<Int, RepoEntity>() {

    private var retryCallback: (() -> Unit)? = null

    private var currentPage: Int = 1

    private val _loadingState = mutableLiveDataOf(LoadingState.INITIAL_LOADING)
    val loadingState: LiveData<LoadingState>
        get() = _loadingState

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, RepoEntity>) {
        currentPage = 1
        getReposUseCase.apply {
            execute(startDate, currentPage.toString())
                .doOnSubscribe { disposable ->
                    add(disposable)
                    _loadingState.postValue(LoadingState.INITIAL_LOADING)
                }.subscribeBy(
                    onSuccess = {
                        _loadingState.value = LoadingState.SUCCESS
                        callback.onResult(it.items, 1, 2)
                        currentPage++
                    },
                    onError = {
                        Timber.e(it)
                        _loadingState.value = LoadingState.error(it.message)
                        retryCallback = { loadInitial(params, callback) }
                    }
                )
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, RepoEntity>) {
        getReposUseCase.apply {
            execute(startDate, params.key.toString())
                .doOnSubscribe { disposable ->
                    add(disposable)
                    _loadingState.postValue(LoadingState.LOADING)
                }.subscribeBy(
                    onSuccess = {
                        currentPage++
                        _loadingState.value = LoadingState.SUCCESS
                        callback.onResult(it.items, params.key + 1)
                    },
                    onError = {
                        Timber.e(it)
                        _loadingState.value = LoadingState.error(it.message)
                        retryCallback = { loadAfter(params, callback) }
                    }
                )
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, RepoEntity>) = Unit

    fun retry() {
        if (retryCallback != null)
            retryCallback?.invoke()
    }
}