package com.example.ialbumseeker.model

data class AlbumSearchResponse(
    val resultCount: Int,
    val results: List<AlbumResult>
)