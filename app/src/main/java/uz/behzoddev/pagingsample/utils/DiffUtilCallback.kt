package uz.behzoddev.pagingsample.utils

import androidx.recyclerview.widget.DiffUtil
import uz.behzoddev.pagingsample.data.models.RedditPost

object DiffUtilCallback : DiffUtil.ItemCallback<RedditPost>() {
    override fun areItemsTheSame(oldItem: RedditPost, newItem: RedditPost): Boolean {
        return oldItem.key == newItem.key
    }

    override fun areContentsTheSame(oldItem: RedditPost, newItem: RedditPost): Boolean {
        return oldItem.key == newItem.key
                && oldItem.score == newItem.score
                && oldItem.commentCount == newItem.commentCount
    }
}