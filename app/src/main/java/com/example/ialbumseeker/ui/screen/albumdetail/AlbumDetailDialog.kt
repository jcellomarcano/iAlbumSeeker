package com.example.ialbumseeker.ui.screen.albumdetail

import android.content.Context
import androidx.appcompat.app.AlertDialog
import com.example.ialbumseeker.R
import com.example.ialbumseeker.domain.model.Album

fun showAlbumDetailsDialog(album: Album, context: Context) {
    AlertDialog.Builder(context, R.style.AppTheme)
        .setTitle("Album Details")
        .setMessage(
            "Primary Genre Name: ${album.primaryGenre}\n" +
                "Collection Price: ${album.collectionPrice}\n" +
                "Currency: ${album.currency}\n" +
                "Copyright: ${album.copyright}"
        )
        .setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }
        .create()
        .show()
}
