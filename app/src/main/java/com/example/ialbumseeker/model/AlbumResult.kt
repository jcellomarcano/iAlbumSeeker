package com.example.ialbumseeker.model

data class AlbumResult(
    val wrapperType: String,
    val collectionName: String,
    val releaseDate: String,
    val artworkUrl100: String,
    val primaryGenreName: String,
    val collectionPrice: Double,
    val currency: String,
    val copyright: String,
    val artistName: String
)