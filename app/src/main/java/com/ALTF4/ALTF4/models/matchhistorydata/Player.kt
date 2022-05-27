package com.ALTF4.ALTF4.models.matchhistorydata


import com.google.gson.annotations.SerializedName

data class Player(val puuid : String, val name : String, val team : String, val character : String, val assets : Assets?, val stats : Stats)
