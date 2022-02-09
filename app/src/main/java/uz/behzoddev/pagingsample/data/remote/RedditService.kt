package uz.behzoddev.pagingsample.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import uz.behzoddev.pagingsample.data.contract.RetrofitContract
import uz.behzoddev.pagingsample.data.models.RedditApiResponse

interface RedditService {

    @GET(RetrofitContract.ENDPOINT)
    suspend fun fetchPosts(
        @Query(RetrofitContract.LIMIT) loadSize: Int = 0,
        @Query(RetrofitContract.AFTER) after: String? = null,
        @Query(RetrofitContract.BEFORE) before: String? = null
    ): Response<RedditApiResponse>
}