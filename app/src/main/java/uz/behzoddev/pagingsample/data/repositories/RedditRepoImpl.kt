package uz.behzoddev.pagingsample.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import kotlinx.coroutines.flow.Flow
import uz.behzoddev.pagingsample.data.datasource.LocalDataSource
import uz.behzoddev.pagingsample.data.models.RedditKeys
import uz.behzoddev.pagingsample.data.models.RedditPost
import uz.behzoddev.pagingsample.data.remote.RedditService
import uz.behzoddev.pagingsample.di.BindModules.LocalDataSourceBinds
import javax.inject.Inject

class RedditRepoImpl @Inject constructor(
    private val redditService: RedditService,
    @LocalDataSourceBinds private val localDataSource: LocalDataSource
): RedditRepo {

    override fun fetchPosts(): Flow<PagingData<RedditPost>> {
        return Pager(
            PagingConfig(pageSize = 40, enablePlaceholders = false)
        ) {
            RedditPagingSource(redditService)
        }.flow
    }

    override suspend fun saveKeys(redditKeys: RedditKeys): Long {
        return localDataSource.saveKeys(redditKeys)
    }

    override suspend fun savePosts(redditPost: List<RedditPost>): Long {
        return localDataSource.savePosts(redditPost)
    }

    override fun getPosts(): PagingSource<Int, RedditPost> {
       return localDataSource.getPosts()
    }

    override suspend fun getRedditKeys(): List<RedditKeys> {
        return localDataSource.getRedditKeys()
    }

}