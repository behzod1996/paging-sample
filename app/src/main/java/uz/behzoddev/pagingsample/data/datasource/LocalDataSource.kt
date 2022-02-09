package uz.behzoddev.pagingsample.data.datasource

import androidx.paging.PagingSource
import uz.behzoddev.pagingsample.data.models.RedditKeys
import uz.behzoddev.pagingsample.data.models.RedditPost

interface LocalDataSource {
    suspend fun saveKeys(redditKeys: RedditKeys): Long
    suspend fun savePosts(redditPosts: List<RedditPost>): Long
    suspend fun getRedditKeys(): List<RedditKeys>
    fun getPosts(): PagingSource<Int,RedditPost>

}