package uz.behzoddev.pagingsample.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import uz.behzoddev.pagingsample.data.models.RedditKeys

@Dao
interface RedditKeysDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveRedditKeys(redditKeys: RedditKeys): Long
    @Query("SELECT * FROM reddit_keys ORDER BY keys_id DESC")
    suspend fun getRedditKeys(): List<RedditKeys>
}