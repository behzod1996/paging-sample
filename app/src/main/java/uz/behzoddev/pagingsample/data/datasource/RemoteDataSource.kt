package uz.behzoddev.pagingsample.data.datasource

import retrofit2.Response
import uz.behzoddev.pagingsample.data.models.RedditApiResponse

interface RemoteDataSource {
    suspend fun fetchPosts(loadSize: Int, after: String?,before: String?): Response<RedditApiResponse>
}