package ma.mohamed.codingchallenge.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView
import ma.mohamed.codingchallenge.R
import ma.mohamed.codingchallenge.domain.entity.RepoEntity
import ma.mohamed.codingchallenge.extensions.bindView

class RepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val repoName: TextView by itemView.bindView(R.id.repo_name) // extension function
    private val repoDesc: TextView by itemView.bindView(R.id.repo_description)
    private val ownerName: TextView by itemView.bindView(R.id.owner_name)
    private val ownerAvatar: CircleImageView by itemView.bindView(R.id.owner_avatar)

    fun bind(repo: RepoEntity?, onClick: (RepoEntity) -> Unit) {
        repo?.apply {
            itemView.setOnClickListener { onClick(repo) }
            repoName.text = name
            repoDesc.text = description
            ownerName.text = owner.login
            ownerAvatar.contentDescription = itemView.context.getString(R.string.owner_avatar_content_desc, owner.login)
            Glide.with(itemView)
                .load(owner.avatar)
                .into(ownerAvatar)
        }
    }

    companion object {
        fun create(parent: ViewGroup): RepoViewHolder {
            val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item_repo, parent, false)
            return RepoViewHolder(v)
        }
    }
}