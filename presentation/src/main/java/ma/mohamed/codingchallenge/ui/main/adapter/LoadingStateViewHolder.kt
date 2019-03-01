package ma.mohamed.codingchallenge.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ma.mohamed.codingchallenge.R
import ma.mohamed.codingchallenge.data.model.LoadingState
import ma.mohamed.codingchallenge.extensions.bindView
import ma.mohamed.codingchallenge.extensions.hide
import ma.mohamed.codingchallenge.extensions.show

class LoadingStateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val retryButton: Button by itemView.bindView(R.id.retry)
    private val error: TextView by itemView.bindView(R.id.error)
    private val progress: ProgressBar by itemView.bindView(R.id.progress)

    fun bind(loadingState: LoadingState?, onRetry: () -> Unit) {
        loadingState?.apply {
            when (this.state) {
                LoadingState.State.LOADING -> {
                    progress.show()
                    error.hide()
                    retryButton.hide()
                }
                else -> {
                    progress.hide()
                    error.show()
                    error.text = this.msg ?: itemView.context.getString(R.string.unknown_error)
                    retryButton.show()
                    retryButton.setOnClickListener { onRetry() }
                }
            }
        }
    }

    companion object {
        fun create(parent: ViewGroup): LoadingStateViewHolder {
            val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item_loading_state, parent, false)
            return LoadingStateViewHolder(v)
        }
    }
}