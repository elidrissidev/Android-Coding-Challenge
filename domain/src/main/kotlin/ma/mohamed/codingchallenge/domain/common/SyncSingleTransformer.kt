package ma.mohamed.codingchallenge.domain.common

import io.reactivex.Single
import io.reactivex.SingleSource

/**
 * A transformer which executes a Single stream synchronously.
 * This is usually used in unit tests.
 */
class SyncSingleTransformer<Stream> : SingleTransformer<Stream> {
    override fun apply(upstream: Single<Stream>): SingleSource<Stream> = upstream
}