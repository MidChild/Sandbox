package org.mathieu.sandbox.ui.screens.episodedetails

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import org.mathieu.sandbox.domain.models.Episode
import org.mathieu.sandbox.ui.components.EpisodeCard

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun EpisodeDetailsScreen(
    episodeId: Int
){
    val viewModel: EpisodeDetailsViewModel = viewModel()
    val state: EpisodeDetailsState by viewModel.state.collectAsState()

    LaunchedEffect(key1 = 0) {
        viewModel.initialize(id = episodeId)
    }

    Content(
        episode = state.episode
    )
}

@RequiresApi(Build.VERSION_CODES.S)
@Composable
private fun Content(
    episode: Episode
) = EpisodeCard(
    episode = Episode(episode.id, episode.date, episode.name)
)