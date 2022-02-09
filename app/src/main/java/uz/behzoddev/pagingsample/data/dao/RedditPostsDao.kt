package uz.behzoddev.pagingsample.data.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import uz.behzoddev.pagingsample.data.models.RedditPost

@Dao
interface RedditPostsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePosts(redditPosts: List<RedditPost>)
    
    @Query("SELECT * FROM reddit_posts")
    fun getPosts(): PagingSource<Int,RedditPost>
}