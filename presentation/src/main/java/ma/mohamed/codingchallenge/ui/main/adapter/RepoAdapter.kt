package ma.mohamed.codingchallenge.ui.main.adapter

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ma.mohamed.codingchallenge.R
import ma.mohamed.codingchallenge.data.model.LoadingState
import ma.mohamed.codingchallenge.domain.entity.RepoEntity

class RepoAdapter(
    private val onClick: (RepoEntity) -> Unit,
    private val onRetry: () -> Unit
) : PagedListAdapter<RepoEntity, RecyclerView.ViewHolder>(DIFF_COMPARATOR) {

    private var loadingState: LoadingState? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.list_item_repo -> RepoViewHolder.create(parent)
            R.layout.list_item_loading_state -> LoadingStateViewHolder.create(parent)
            else -> throw IllegalStateException("Unsupported viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is RepoViewHolder -> holder.bind(getItem(position), onClick)
            is LoadingStateViewHolder -> holder.bind(loadingState, onRetry)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (hasLoadingFooter() && position == itemCount - 1)
            R.layout.list_item_loading_state
        else
            R.layout.list_item_repo
    }

    override fun getItemCount(): Int {
        return super.getItemCount() + if (hasLoadingFooter()) 1 else 0
    }

    fun setLoadingState(newLoadingState: LoadingState) {
        if (currentList != null) {
            if (currentList!!.size != 0) {
                val previousState = this.loadingState
                val hadLoadingFooter = hasLoadingFooter()
                this.loadingState = newLoadingState
                val hasLoadingFooter = hasLoadingFooter()
                if (hasLoadingFooter != hadLoadingFooter) {
                    if (hadLoadingFooter)
                        notifyItemRemoved(super.getItemCount())
                    else
                        notifyItemInserted(super.getItemCount())
                } else if (hasLoadingFooter && previousState !== newLoadingState) {
                    notifyItemChanged(itemCount - 1)
                }
            }
        }
    }

    private fun hasLoadingFooter(): Boolean {
        return loadingState != null && loadingState != LoadingState.SUCCESS
                && loadingState != LoadingState.INITIAL_LOADING
    }

    companion object {
        val DIFF_COMPARATOR = object : DiffUtil.ItemCallback<RepoEntity>() {
            override fun areItemsTheSame(oldItem: RepoEntity, newItem: RepoEntity): Boolean = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: RepoEntity, newItem: RepoEntity): Boolean = oldItem == newItem
        }
    }
}