package uz.behzoddev.pagingsample.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import uz.behzoddev.pagingsample.data.contract.RoomContract

@Entity(tableName = RoomContract.RedditPosts.TABLE_NAME)
@JsonClass(generateAdapter = true)
data class RedditPost(

    @Json (name = "name")
    @ColumnInfo(name = RoomContract.RedditPosts.POST_KEY)
    val key: String,

    @Json (name = "title")
    @ColumnInfo(name = RoomContract.RedditPosts.POST_TITLE)
    val title: String,

    @Json (name = "score")
    @ColumnInfo(name = RoomContract.RedditPosts.POST_SCORE)
    val score: Int,

    @Json (name = "author")
    @ColumnInfo(name = RoomContract.RedditPosts.POST_AUTHOR)
    val author: String,

    @Json (name = "num_comments")
    @ColumnInfo(name = RoomContract.RedditPosts.POST_COMMENT_COUNT)
    val commentCount: Int
)
