package com.example.ialbumseeker.di

import com.example.ialbumseeker.data.api.AlbumApiService
import com.example.ialbumseeker.data.repository.AlbumRepository
import com.example.ialbumseeker.data.repository.AlbumRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideAlbumApiService(client: HttpClient): AlbumApiService {
        return AlbumApiService(client)
    }

    @Provides
    fun provideAlbumRepository(albumApiService: AlbumApiService): AlbumRepository {
        return AlbumRepositoryImpl(albumApiService)
    }

    @Provides
    fun provideHttpClient(): HttpClient {
        return HttpClient()
    }

}
