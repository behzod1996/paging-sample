package uz.behzoddev.pagingsample.domain

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import uz.behzoddev.pagingsample.data.models.RedditPost
import uz.behzoddev.pagingsample.data.repositories.RedditRepo
import uz.behzoddev.pagingsample.di.BindModules.RepositoryBinds
import javax.inject.Inject

class FetchPostsUseCase @Inject constructor(
    @RepositoryBinds private val redditRepo: RedditRepo
) {
    operator fun invoke(): Flow<PagingData<RedditPost>> {
        return redditRepo.fetchPosts()
    }
}