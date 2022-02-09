package uz.behzoddev.pagingsample.data.repositories

import androidx.paging.PagingSource
import androidx.paging.PagingState
import retrofit2.HttpException
import uz.behzoddev.pagingsample.data.models.RedditPost
import uz.behzoddev.pagingsample.data.remote.RedditService
import java.io.IOException
import javax.inject.Inject

class RedditPagingSource @Inject constructor(
   private val redditService: RedditService
) : PagingSource<String, RedditPost>() {

    override suspend fun load(params: LoadParams<String>): LoadResult<String, RedditPost> {
        return try {
            val response  = redditService.fetchPosts(loadSize = params.loadSize)
            val listing = response.body()?.data
            val redditPost = listing?.children?.map { it.data }

            LoadResult.Page(
                redditPost ?: listOf(),
                listing?.before,
                listing?.after
            )
        } catch (exception: IOException) {
            exception.printStackTrace()
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            exception.printStackTrace()
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<String, RedditPost>): String? {
        TODO("Not yet implemented")
    }
}