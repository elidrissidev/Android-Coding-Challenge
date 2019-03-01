package ma.mohamed.codingchallenge.extensions

/**
 * Creates a new instance of the [Lazy] that uses the specified initialization function [initializer]
 * and uses [LazyThreadSafetyMode.NONE].
 * This should not be used unless the [Lazy] instance is guaranteed *never* to be initialized from more than one thread.
 */
internal fun <T> lazyUnSync(initializer: () -> T): Lazy<T> = lazy(LazyThreadSafetyMode.NONE, initializer)