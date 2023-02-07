package com.example.ialbumseeker.data.repository

import com.example.ialbumseeker.domain.model.Album
import kotlinx.coroutines.flow.Flow

interface AlbumRepository {
    fun searchAlbums(artistName: String): Flow<List<Album>>
}