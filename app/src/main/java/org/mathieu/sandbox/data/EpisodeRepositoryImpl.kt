package org.mathieu.sandbox.data

import org.mathieu.sandbox.domain.models.Episode
import org.mathieu.sandbox.domain.repositories.IEpisodeRepository

object EpisodeRepositoryImpl : IEpisodeRepository {
    override fun getEpisodeByIdOrNull(id: Int): Episode? {

        // Retrieves the mock data from a local source
        return EpisodeLocal.episodes.find { episode ->
            episode.id == id
        }
    }

    override fun getEpisodes() = EpisodeLocal.episodes

}