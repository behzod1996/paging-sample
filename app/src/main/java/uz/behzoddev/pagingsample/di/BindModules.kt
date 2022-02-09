package uz.behzoddev.pagingsample.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.behzoddev.pagingsample.data.datasource.LocalDataSource
import uz.behzoddev.pagingsample.data.datasource.LocalDataSourceImpl
import uz.behzoddev.pagingsample.data.datasource.RemoteDataSource
import uz.behzoddev.pagingsample.data.datasource.RemoteDataSourceImpl
import uz.behzoddev.pagingsample.data.repositories.RedditRepo
import uz.behzoddev.pagingsample.data.repositories.RedditRepoImpl
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class BindModules {

    @Binds
    @LocalDataSourceBinds
    @Singleton
    abstract fun provideLocalDataSourceInstance
                (localDataSourceImpl: LocalDataSourceImpl): LocalDataSource

    @Binds
    @RemoteDataSourceBinds
    @Singleton
    abstract fun provideRemoteDataSourceInstance
                (remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource

    @Binds
    @RepositoryBinds
    @Singleton
    abstract fun providesRepositoryInstance(redditRepoImpl: RedditRepoImpl): RedditRepo

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class LocalDataSourceBinds

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class RemoteDataSourceBinds

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class RepositoryBinds

}