package ma.mohamed.codingchallenge.extensions

import android.app.Activity
import android.view.View
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView

/**
 * Similar to [Activity.bindView] but available to use within a [RecyclerView.ViewHolder].
 */
internal fun <T : View> View.bindView(@IdRes id: Int): Lazy<T> {
    return lazyUnSync { this.findViewById<T>(id) }
}
