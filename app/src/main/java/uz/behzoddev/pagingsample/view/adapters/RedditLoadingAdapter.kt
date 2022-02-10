package uz.behzoddev.pagingsample.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.behzoddev.pagingsample.databinding.StateLoadingBinding

class RedditLoadingAdapter (private val retry: () -> Unit)
    : LoadStateAdapter<RedditLoadingAdapter.RedditLoadingViewHolder>() {

    inner class RedditLoadingViewHolder(private val binding: StateLoadingBinding, retry: () -> Unit) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.btnRetry.setOnClickListener {
                retry.invoke()
            }
        }

        fun bindState(loadState: LoadState) {
            if (loadState is LoadState.Error) {
                binding.tvErrorMsg.text = loadState.error.localizedMessage
            }
            binding.progressBar.isVisible = loadState is LoadState.Loading
            binding.tvErrorMsg.isVisible = loadState !is LoadState.Loading
            binding.btnRetry.isVisible = loadState !is LoadState.Loading
        }
    }

    override fun onBindViewHolder(holder: RedditLoadingViewHolder, loadState: LoadState) {
        holder.bindState(loadState)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): RedditLoadingViewHolder {
        val binding = StateLoadingBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RedditLoadingViewHolder(binding,retry)
    }

}