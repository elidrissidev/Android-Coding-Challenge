package ma.mohamed.codingchallenge.domain.usecase.base

import io.reactivex.disposables.Disposable

/**
 * A base type that defines a Use Case.
 * Each use case in the application should implement this contract.
 */
interface UseCase<in Params, out R> : Disposable {
    fun add(d: Disposable)
    fun execute(vararg params: Params): R
    override fun isDisposed(): Boolean
    override fun dispose()
}