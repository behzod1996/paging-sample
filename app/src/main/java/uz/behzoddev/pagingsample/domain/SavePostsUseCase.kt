package uz.behzoddev.pagingsample.domain

import uz.behzoddev.pagingsample.data.models.RedditPost
import uz.behzoddev.pagingsample.data.repositories.RedditRepo
import uz.behzoddev.pagingsample.di.BindModules.RepositoryBinds
import javax.inject.Inject

class SavePostsUseCase @Inject constructor(
    @RepositoryBinds private val redditRepo: RedditRepo
){
    suspend operator fun invoke(redditPosts: List<RedditPost>): Long {
        return redditRepo.savePosts(redditPosts)
    }
}