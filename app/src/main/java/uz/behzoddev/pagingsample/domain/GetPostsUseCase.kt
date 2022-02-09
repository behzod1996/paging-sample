package uz.behzoddev.pagingsample.domain

import androidx.paging.PagingSource
import uz.behzoddev.pagingsample.data.models.RedditPost
import uz.behzoddev.pagingsample.data.repositories.RedditRepo
import uz.behzoddev.pagingsample.di.BindModules.RepositoryBinds
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
    @RepositoryBinds private val redditRepo: RedditRepo
) {
    operator fun invoke(): PagingSource<Int, RedditPost> {
        return redditRepo.getPosts()
    }
}