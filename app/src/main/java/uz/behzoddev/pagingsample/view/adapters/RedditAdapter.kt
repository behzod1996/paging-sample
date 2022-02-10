package uz.behzoddev.pagingsample.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.behzoddev.pagingsample.data.models.RedditPost
import uz.behzoddev.pagingsample.databinding.ItemRowBinding
import uz.behzoddev.pagingsample.utils.DiffUtilCallback

class RedditAdapter : PagingDataAdapter<RedditPost, RedditAdapter.RedditViewHolder>(DiffUtilCallback) {

    override fun onBindViewHolder(holder: RedditViewHolder, position: Int) {
       getItem(position)?.let { holder.bindPosts(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RedditViewHolder {
        val binding = ItemRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RedditViewHolder(binding)
    }

    inner class RedditViewHolder(private val binding: ItemRowBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindPosts(redditPost: RedditPost) {
            with(redditPost) {
                binding.tvFavouriteQuantity.text = score.toString()
                binding.tvCommentQuantity.text = commentCount.toString()
                binding.tvTitle.text = title
            }
        }
    }
}