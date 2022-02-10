package uz.behzoddev.pagingsample.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import uz.behzoddev.pagingsample.data.models.RedditPost
import uz.behzoddev.pagingsample.domain.FetchPostsUseCase
import javax.inject.Inject

@HiltViewModel
class RedditViewModel @Inject constructor(
    private val fetchPostsUseCase: FetchPostsUseCase
): ViewModel() {

    fun fetchPosts(): Flow<PagingData<RedditPost>> {
        return fetchPostsUseCase.invoke().cachedIn(viewModelScope)
    }
}