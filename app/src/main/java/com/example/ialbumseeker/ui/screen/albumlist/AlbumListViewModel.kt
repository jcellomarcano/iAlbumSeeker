package com.example.ialbumseeker.ui.screen.albumlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ialbumseeker.data.repository.AlbumRepository
import com.example.ialbumseeker.domain.model.Album
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumListViewModel @Inject constructor(
    private val repository: AlbumRepository
) : ViewModel() {
    private val _albums = MutableStateFlow<List<Album>>(emptyList())
    val albums: StateFlow<List<Album>>
        get() = _albums

    fun getAlbums(artist: String) {
        viewModelScope.launch {
            repository.searchAlbums(artist)
                .collect {
                    _albums.value = it
                }
        }
    }
}
