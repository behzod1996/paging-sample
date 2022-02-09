package uz.behzoddev.pagingsample.data.datasource

import androidx.paging.PagingSource
import uz.behzoddev.pagingsample.data.dao.RedditKeysDao
import uz.behzoddev.pagingsample.data.dao.RedditPostsDao
import uz.behzoddev.pagingsample.data.models.RedditKeys
import uz.behzoddev.pagingsample.data.models.RedditPost
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val keysDao: RedditKeysDao,
    private val postsDao: RedditPostsDao
) : LocalDataSource {

    override suspend fun saveKeys(redditKeys: RedditKeys): Long {
        return keysDao.saveRedditKeys(redditKeys)
    }

    override suspend fun savePosts(redditPosts: List<RedditPost>): Long {
        return postsDao.savePosts(redditPosts)
    }

    override fun getPosts(): PagingSource<Int,RedditPost> {
        return postsDao.getPosts()
    }

    override suspend fun getRedditKeys(): List<RedditKeys> {
        return keysDao.getRedditKeys()
    }
}