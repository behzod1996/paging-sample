package uz.behzoddev.pagingsample.data.datasource

import retrofit2.Response
import uz.behzoddev.pagingsample.data.models.RedditApiResponse
import uz.behzoddev.pagingsample.data.remote.RedditService
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val redditService: RedditService
) : RemoteDataSource {
    override suspend fun fetchPosts(
        loadSize: Int,
        after: String?,
        before: String?
    ): Response<RedditApiResponse> {
        return redditService.fetchPosts(loadSize,after,before)
    }
}