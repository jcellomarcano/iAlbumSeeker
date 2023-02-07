package com.example.ialbumseeker.data.repository

import com.example.ialbumseeker.data.api.AlbumApiService
import com.example.ialbumseeker.domain.model.Album
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AlbumRepositoryImpl @Inject constructor(private val albumApiService: AlbumApiService) : AlbumRepository {
    override fun searchAlbums(artistName: String): Flow<List<Album>> {
        return albumApiService.searchAlbums(artistName)
    }
}
