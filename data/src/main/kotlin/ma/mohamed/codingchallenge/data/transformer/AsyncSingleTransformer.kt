package ma.mohamed.codingchallenge.data.transformer

import io.reactivex.Single
import io.reactivex.SingleSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ma.mohamed.codingchallenge.domain.common.SingleTransformer

/**
 * A transformer which executes a Single stream asynchronously.
 */
class AsyncSingleTransformer<Stream> : SingleTransformer<Stream> {
    override fun apply(upstream: Single<Stream>): SingleSource<Stream> {
        return upstream.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}