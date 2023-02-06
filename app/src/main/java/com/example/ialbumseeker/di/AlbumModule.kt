package com.example.ialbumseeker.di

import com.example.ialbumseeker.data.api.AlbumApi
import com.example.ialbumseeker.data.repository.AlbumRepository
import com.example.ialbumseeker.data.repository.AlbumRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import retrofit2.Retrofit

@Module
@InstallIn(ActivityRetainedComponent::class)
class AlbumModule {

    @Provides
    fun provideAlbumRepository(albumApi: AlbumApi): AlbumRepository {
        return AlbumRepositoryImpl(albumApi)
    }

    @Provides
    fun provideAlbumApi(): AlbumApi {
        return Retrofit.Builder()
            .baseUrl("https://itunes.apple.com/")
            .build()
            .create(AlbumApi::class.java)
    }
}
