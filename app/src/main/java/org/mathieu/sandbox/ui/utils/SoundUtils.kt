package org.mathieu.sandbox.ui.utils

import android.content.Context
import android.media.MediaPlayer
import org.mathieu.sandbox.R

/**
 * Prepares and launches a sound effect.
 * @param context The current context of the Composable
 **/
fun LaunchSound(context: Context){

    // Creates a Media Player that is ready to launch
    val au : MediaPlayer = MediaPlayer.create(context, R.raw.click)

    // Starts the media player
    au.start()
}