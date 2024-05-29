package org.mathieu.sandbox.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import org.mathieu.sandbox.domain.models.Episode
import org.mathieu.sandbox.ui.utils.LaunchSound
import org.mathieu.sandbox.ui.utils.StartVibration



@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun EpisodeCard(
    episode: Episode,
    onClick: (() -> Unit)? = null
) {
    val context = LocalContext.current

    // OnClick was made nullable so it can be disabled on the Episode Detail page
    Column(modifier = if (onClick != null){
        Modifier.clickable(onClick = {

            StartVibration(context = context)
            LaunchSound(context = context)
            onClick.invoke()
        })
    } else{
        Modifier
    }
    ) {
        Text(text = episode.date,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = "S1E${episode.id} - ${episode.name}",
            fontWeight = FontWeight.Bold
        )
    }
}