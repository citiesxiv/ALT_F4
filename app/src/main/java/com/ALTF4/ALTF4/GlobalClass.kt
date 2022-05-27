package com.ALTF4.ALTF4

import android.app.Application
import com.ALTF4.ALTF4.models.Player

class GlobalClass : Application() {
    companion object {
        var Player : Player? = null
    }
}