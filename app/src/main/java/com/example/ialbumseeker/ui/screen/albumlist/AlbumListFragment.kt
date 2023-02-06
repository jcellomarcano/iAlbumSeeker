package com.example.ialbumseeker.ui.screen.albumlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlbumListFragment : Fragment() {
    private val viewModel: AlbumListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposableLayout(container) {
            Column(
                modifier = Modifier.fillMaxSize().padding(16.dp)
            ) {
                val searchState = state { "" }
                TextField(
                    value = searchState.value,
                    onValueChange = { searchState.value = it },
                    modifier = Modifier.fillMaxWidth().padding(16.dp)
                )
                AlbumList(albums = viewModel.albums.collectAsState().value)
            }
        }.apply {
            viewModel.searchAlbums(searchState.value)
        }
    }
}

@Composable
fun AlbumList(albums: Result<List<Album>>) {
    when (albums) {
        is Result.Loading -> {
            // show a loading indicator
        }
        is Result.Success -> {
            // show a list of albums
            LazyColumnFor(albums.data) { album ->
                AlbumRow(album)
            }
        }
        is Result.Error -> {
            // show an error message
        }
    }
}

@Composable
fun AlbumRow(album: Album) {
    // show the album artwork, name, and release date
    Row(
        modifier = Modifier.padding(16.dp)
    ) {
        // show the album artwork
        // ...
        Column {
            // show the album name
            // ...
            // show the release date
            // ...
        }
    }
    // when the row is clicked, show the album details dialog
    // ...
}