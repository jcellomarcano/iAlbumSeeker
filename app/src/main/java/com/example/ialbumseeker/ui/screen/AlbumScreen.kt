package com.example.ialbumseeker.ui.screen

import AlbumRow
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.ialbumseeker.ui.screen.albumlist.AlbumListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlbumScreen(viewModel: AlbumListViewModel) {
    val albums = viewModel.albums.collectAsState(initial = emptyList()).value
    var searchTerm by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TextField(
            value = searchTerm,
            onValueChange = {
                viewModel.getAlbums(it)
                searchTerm = it
            },
            label = { Text("Search by Artist") },
            modifier = Modifier.fillMaxWidth()
        )
        LazyColumn {
            items(albums) {
                    album ->
                AlbumRow(album = album)
            }
        }
    }
}
