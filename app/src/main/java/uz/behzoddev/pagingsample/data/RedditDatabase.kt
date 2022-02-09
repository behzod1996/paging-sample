package uz.behzoddev.pagingsample.data

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.hilt.android.qualifiers.ApplicationContext
import uz.behzoddev.pagingsample.data.contract.RoomContract
import uz.behzoddev.pagingsample.data.dao.RedditKeysDao
import uz.behzoddev.pagingsample.data.dao.RedditPostsDao

abstract class RedditDatabase : RoomDatabase() {

    abstract fun getKeysDao(): RedditKeysDao
    abstract fun getPostsDao(): RedditPostsDao

    companion object {
        @Volatile
        private var INSTANCE: RedditDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = INSTANCE ?: synchronized(LOCK) {
            INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
        }
        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            RedditDatabase::class.java,
            RoomContract.DATABASE_NAME
        ).build()
    }
}