package com.example.ialbumseeker.domain.usecase

import com.example.ialbumseeker.data.repository.AlbumRepository
import com.example.ialbumseeker.domain.model.Album
import javax.inject.Inject

class GetAlbumsUseCase @Inject constructor(
    private val albumRepository: AlbumRepository
) {
    suspend fun execute(artist: String): List<Album> {
        return albumRepository.searchAlbums(artist)
    }
}