package com.example.ialbumseeker.data.api // ktlint-disable filename

import android.util.Log
import com.example.ialbumseeker.domain.model.Album
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.json.JSONObject
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AlbumApiService @Inject constructor(private val client: HttpClient) {

    fun searchAlbums(artistName: String): Flow<List<Album>> {
        return flow {
            val response = client.get<String>("https://itunes.apple.com/search?term=$artistName&entity=album")
            val albumResults = parseAlbumResults(response)
            emit(albumResults)
        }
    }

    private fun parseAlbumResults(response: String): List<Album> {
        try {
            val albums = mutableListOf<Album>()
            val jsonResponse = JSONObject(response)
            val results = jsonResponse.getJSONArray("results")
            for (i in 0 until results.length()) {
                val result = results.getJSONObject(i)
                val album = Album(
                    result.getString("collectionName"),
                    result.getString("releaseDate"),
                    result.getString("artworkUrl100"),
                    result.getString("primaryGenreName"),
                    result.getDouble("collectionPrice"),
                    result.getString("currency"),
                    result.getString("copyright"),
                    result.getString("artistName")
                )
                albums.add(album)
            }
            return albums
        } catch (e: Exception) {
            Log.i("ErrorParsing", "parseAlbumResults: Error: ${e.message}")
            return emptyList()
        }
    }
}
