package ma.mohamed.codingchallenge.domain.usecase.base

import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * An implementation of [UseCase] which is meant to be sub-classed by use cases where
 * the return type of [SingleUseCase.execute] is a [Single]
 */
abstract class SingleUseCase<in Params, out R: Single<*>> : UseCase<Params, R> {

    private val compositeDisposable by lazy { CompositeDisposable() }

    override fun add(d: Disposable) {
        compositeDisposable.add(d)
    }

    abstract override fun execute(vararg params: Params): R

    override fun isDisposed(): Boolean = compositeDisposable.isDisposed

    override fun dispose() = compositeDisposable.dispose()
}