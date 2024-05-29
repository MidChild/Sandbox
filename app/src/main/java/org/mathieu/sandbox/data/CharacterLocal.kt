package org.mathieu.sandbox.data

import org.mathieu.sandbox.domain.models.Character
import org.mathieu.sandbox.domain.models.Episode

object CharacterLocal {

    // MOCK DATA
    var characters: MutableList<Character> = mutableListOf(
        Character(
            id = 1,
            firstName = "John",
            lastName = "Snow",
            age = 20,
            episodes = EpisodeLocal.episodes
        ),
        Character(
            id = 2,
            firstName = "Jack",
            lastName = "Sparrow",
            age = 21,
            episodes = EpisodeLocal.episodes.filter { episode: Episode -> (episode.id%2) != 0 }
        ),
        Character(
            id = 3,
            firstName = "Jordan",
            lastName = "Emma",
            age = 22,
            episodes = EpisodeLocal.episodes.filter { episode: Episode -> (episode.id%2) == 0 }
        )
    )
}