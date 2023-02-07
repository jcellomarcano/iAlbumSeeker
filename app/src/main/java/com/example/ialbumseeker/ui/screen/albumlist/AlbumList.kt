import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.ialbumseeker.R
import com.example.ialbumseeker.domain.model.Album
import com.example.ialbumseeker.ui.screen.albumdetail.showAlbumDetailsDialog

@Composable
fun AlbumRow(album: Album) {
    val context = LocalContext.current
    Row(
        modifier = Modifier.clickable(
            onClick = { showAlbumDetailsDialog(album, context) }
        )
    ) {
        AsyncImage(
            model = album.artworkUrl,
            modifier = Modifier.size(40.dp),
            placeholder = painterResource(R.drawable.ic_launcher_background),
            contentDescription = "Album artwork"
        )
        Column(modifier = Modifier.padding(start = 16.dp)) {
            album.name?.let { Text(it) }
            Text("Release Date: ${album.releaseDate}")
        }
    }
}
