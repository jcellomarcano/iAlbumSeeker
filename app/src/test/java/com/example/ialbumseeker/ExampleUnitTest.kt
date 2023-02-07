package com.example.ialbumseeker

import android.annotation.SuppressLint
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.ialbumseeker.data.repository.AlbumRepository
import com.example.ialbumseeker.domain.model.Album
import com.example.ialbumseeker.ui.screen.albumlist.AlbumListViewModel
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.MutableStateFlow
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.verify

@RunWith(JUnit4::class)
class AlbumViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val albumRepository = mockk<AlbumRepository>()
    private lateinit var albumViewModel: AlbumListViewModel

    @Before
    fun setup() {
        clearAllMocks()
        albumViewModel = AlbumListViewModel(albumRepository)
    }

    @SuppressLint("CheckResult")
    @Test
    fun testFetchAlbums() {
        val albums = listOf(
            Album("1", "Album 1", "2021-01-01", "", 0.0, "", "", ""),
            Album("2", "Album 2", "2022-01-01", "", 0.0, "", "", "")
        )
        val albumLiveData = MutableStateFlow<List<Album>>(emptyList())
        albumLiveData.value = albums
        every { albumRepository.searchAlbums("artist name") } returns albumLiveData

        albumViewModel.getAlbums("artist name")

        verify(albumRepository.searchAlbums("artist name"))
        assert(albumViewModel.albums.value == albums)
    }
}
