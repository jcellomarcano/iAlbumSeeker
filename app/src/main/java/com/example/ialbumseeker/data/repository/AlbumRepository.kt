package com.example.ialbumseeker.data.repository

import com.example.ialbumseeker.domain.model.Album

interface AlbumRepository {
    suspend fun searchAlbums(artist: String): List<Album>
}