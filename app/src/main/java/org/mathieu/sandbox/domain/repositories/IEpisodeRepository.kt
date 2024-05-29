package org.mathieu.sandbox.domain.repositories

import org.mathieu.sandbox.domain.models.Episode

interface IEpisodeRepository {
    /**
     * Tries to retrieve an episode, using its id. If there is no episode found, then it returns null.
     *
     * @param id The id of the episode we are looking for
     * @return It returns either an [Episode] or null if not found.
     */
    fun getEpisodeByIdOrNull(id: Int): Episode?

    /**
     * Fetches every available episode
     *
     * @return It returns a list of [Episode].
     */
    fun getEpisodes(): List<Episode>

}