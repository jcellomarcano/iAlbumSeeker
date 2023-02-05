package com.example.ialbumseeker.model

data class Album(
    val artistName: String,
    val releaseDate: String,
    val name: String,
    val artworkUrl100: String,
    val primaryGenreName: String,
    val collectionPrice: Double,
    val currency: String,
    val copyright: String
)