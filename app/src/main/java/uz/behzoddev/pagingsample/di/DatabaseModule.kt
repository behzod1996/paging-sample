package uz.behzoddev.pagingsample.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.behzoddev.pagingsample.data.RedditDatabase
import uz.behzoddev.pagingsample.data.dao.RedditKeysDao
import uz.behzoddev.pagingsample.data.dao.RedditPostsDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesRoomInstance(application: Application): RedditDatabase {
        return RedditDatabase.invoke(application.applicationContext)
    }

    @Provides
    @Singleton
    fun providesKeysDaoInstance(redditDatabase: RedditDatabase): RedditKeysDao {
        return redditDatabase.getKeysDao()
    }

    @Provides
    @Singleton
    fun providesPostsDaoInstance(redditDatabase: RedditDatabase): RedditPostsDao {
        return redditDatabase.getPostsDao()
    }
}