package org.mathieu.sandbox.data

import org.mathieu.sandbox.domain.models.Episode

object EpisodeLocal {
    // MOCK DATA
    var episodes: MutableList<Episode> = mutableListOf(
        Episode(
            1,
            "09/12/13",
            "Pilot"
        ),
        Episode(
            2,
            "16/12/13",
            "Lawnmower Dog"
        ),
        Episode(
            3,
            "06/01/14",
            "Anatomy Park"
        ),
        Episode(
            4,
            "03/02/14",
            "M. Night Shaym-Aliens!"
        ),
        Episode(
            5,
            "09/02/14",
            "Meeseeks and Destroy"
        )
    )
}