package uz.behzoddev.pagingsample.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import uz.behzoddev.pagingsample.data.contract.RetrofitContract
import uz.behzoddev.pagingsample.data.remote.RedditService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Provides
    @Singleton
    fun providesRetrofitInstance(
        moshiConverterFactory: MoshiConverterFactory,
        client: OkHttpClient
    ) : RedditService {
        return Retrofit.Builder().run {
            baseUrl(RetrofitContract.BASE_URL)
            addConverterFactory(moshiConverterFactory)
            client(client)
            build()
        }.run {
            create(RedditService::class.java)
        }
    }

    @Provides
    @Singleton
    fun providesMoshiInstance() : MoshiConverterFactory {
        return MoshiConverterFactory.create()
    }

    @Provides
    @Singleton
    fun providesOkHttpClientInstance(loggingInterceptor: HttpLoggingInterceptor) = OkHttpClient().apply {
        OkHttpClient.Builder().run {
            addInterceptor(loggingInterceptor)
            build()
        }
    }

    @Provides
    @Singleton
    fun providesLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
}