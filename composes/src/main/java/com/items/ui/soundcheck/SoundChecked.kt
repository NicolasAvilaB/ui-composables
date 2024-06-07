package com.items.ui.soundcheck

import android.content.Context
import android.media.MediaPlayer
import com.items.ui.composes.R

fun soundChecked(context: Context) {
    val mediaPlayer = MediaPlayer.create(context, R.raw.beep)
    mediaPlayer.start()
    mediaPlayer.setOnCompletionListener { mp ->
        mp.release()
    }
}

fun soundErrorChecked(context: Context) {
    val mediaPlayer = MediaPlayer.create(context, R.raw.beep_error)
    mediaPlayer.start()
    mediaPlayer.setOnCompletionListener { mp ->
        mp.release()
    }
}