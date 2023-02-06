package com.example.ialbumseeker.data.api

import com.example.ialbumseeker.model.AlbumSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface AlbumApi {
    @GET("search")
    suspend fun searchAlbums(
        @Query("term") term: String,
        @Query("entity") entity: String = "album"
    ): AlbumSearchResponse
}