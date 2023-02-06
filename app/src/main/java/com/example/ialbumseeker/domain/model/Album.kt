package com.example.ialbumseeker.domain.model

data class Album(
    val name: String,
    val releaseDate: String,
    val artworkUrl: String,
    val primaryGenre: String,
    val collectionPrice: Double,
    val currency: String,
    val copyright: String
)