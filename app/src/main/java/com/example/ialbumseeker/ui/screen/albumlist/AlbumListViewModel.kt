package com.example.ialbumseeker.ui.screen.albumlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ialbumseeker.domain.model.Album
import com.example.ialbumseeker.domain.usecase.GetAlbumsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class AlbumListViewModel  constructor(
    private val getAlbumsUseCase: GetAlbumsUseCase
) : ViewModel() {
    private val _albums = MutableStateFlow<Result<List<Album>>>(Result.Loading)
    val albums: StateFlow<Result<List<Album>>>
        get() = _albums

    fun searchAlbums(artist: String) {
        viewModelScope.launch {
            _albums.value = Result.Loading
            _albums.value = getAlbumsUseCase.execute(artist).first()
        }
    }
}