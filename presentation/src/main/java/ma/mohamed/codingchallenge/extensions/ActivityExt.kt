package ma.mohamed.codingchallenge.extensions

import android.app.Activity
import android.view.View
import androidx.annotation.IdRes

/**
 * Binds a view with its id lazily with [LazyThreadSafetyMode.NONE] to improve performance
 * since we're only going to be using it in the main thread.
 * Thanks to: https://link.medium.com/QmHuXgmeau
 *
 * @param id The id of the view to bind
 *
 * @return a lazy initializer that will call [Activity.findViewById].
 */
internal fun <T : View> Activity.bindView(@IdRes id: Int): Lazy<T> {
    return lazyUnSync { this.findViewById<T>(id) }
}
