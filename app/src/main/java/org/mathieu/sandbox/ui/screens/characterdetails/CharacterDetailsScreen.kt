package org.mathieu.sandbox.ui.screens.characterdetails

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import org.mathieu.sandbox.domain.models.Episode
import org.mathieu.sandbox.ui.components.EpisodeCard


@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun CharacterDetailsScreen(
    navController: NavController,
    characterId: Int
) {
    val viewModel: CharacterDetailsViewModel = viewModel()
    val state: CharacterDetailsState by viewModel.state.collectAsState()

    LaunchedEffect(viewModel.events) {
        viewModel.initialize(id = characterId)

        viewModel.events
            .onEach { event ->
                when(event){
                    is CharacterDetailsEvent.NavigateToDetails -> navController.navigate(
                        route = "episodes/${event.id}"
                    )
                }
            }.collect()
    }

    Content(
        state = state,
        clickOnCard = {
            viewModel.navigateToDetails(it)
        }
    )
}


@RequiresApi(Build.VERSION_CODES.S)
@Composable
private fun Content(
    state: CharacterDetailsState,
    clickOnCard: (Int) -> Unit
) = Column(verticalArrangement = Arrangement.spacedBy(30.dp)) {
    CharacterCard(state = state)
    EpisodesList(episodes = state.episodes, clickedOnCard = clickOnCard)
}

@Composable
private fun CharacterCard(
    state: CharacterDetailsState
) = Column {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Text(text = state.firstName)
        Text(text = state.lastName)
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Composable
private fun EpisodesList(
    episodes: List<Episode>,
    clickedOnCard: (Int) -> Unit
) = LazyColumn(
    modifier = Modifier
        .border(BorderStroke(1.dp, Color.Black), RoundedCornerShape(1.dp))
        .padding(10.dp),
    verticalArrangement = Arrangement.spacedBy(15.dp)
) {
    items(episodes){episode ->
        EpisodeCard(episode, onClick =  { clickedOnCard(episode.id) })
        if(episode.id < episodes.last().id){
            Divider(color = Color.Gray, thickness = 1.dp)
        }
    }
}


