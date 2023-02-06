package com.example.ialbumseeker.data.repository

import com.example.ialbumseeker.data.api.AlbumApi
import com.example.ialbumseeker.domain.model.Album
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AlbumRepositoryImpl @Inject constructor(
    private val albumApi: AlbumApi
) : AlbumRepository {
    override suspend fun searchAlbums(artist: String): List<Album> {
        val response = albumApi.searchAlbums(artist)
        return response.results
            .filter { it.wrapperType == "collection" }
            .map {
                Album(
                    it.collectionName,
                    it.releaseDate,
                    it.artworkUrl100,
                    it.primaryGenreName,
                    it.collectionPrice,
                    it.currency,
                    it.copyright
                )
            }
    }
}