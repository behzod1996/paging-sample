package uz.behzoddev.pagingsample.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import uz.behzoddev.pagingsample.data.contract.RoomContract

@Entity(tableName = RoomContract.RedditKeys.TABLE_NAME)
data class RedditKeys(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = RoomContract.RedditKeys.KEYS_ID)
    val id: Int,

    @ColumnInfo(name = RoomContract.RedditKeys.KEYS_AFTER)
    val after: String?,

    @ColumnInfo(name = RoomContract.RedditKeys.KEYS_BEFORE)
    val before: String?
)
