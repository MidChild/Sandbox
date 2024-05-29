package org.mathieu.sandbox.ui.utils

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.VibratorManager
import androidx.annotation.RequiresApi


/**
 * Prepares the vibrators and makes the smartphone vibrate.
 * @param context The current context of the Composable
 */
@RequiresApi(Build.VERSION_CODES.S)
fun StartVibration(context: Context){

    // Creation an instance of the Vibrator Manager that provides access to all vibrators from the devices
    val vibratorManager = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager

    // Creation an instance of the Vibrator
    val vibrator = vibratorManager.getDefaultVibrator()

    // Creates the configurated vibration effect
    val vibrationEffect = VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE)

    vibrator.vibrate(vibrationEffect)
}