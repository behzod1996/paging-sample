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

interface RedditRepo {
    fun fetchPosts() : Flow<PagingData<RedditPost>>
    suspend fun saveKeys(redditKeys: RedditKeys): Long
    suspend fun savePosts(redditPost: List<RedditPost>): Long
    fun getPosts(): PagingSource<Int, RedditPost>
    suspend fun getRedditKeys(): List<RedditKeys>
}