package com.ALTF4.ALTF4.models.matchhistorydata


import com.google.gson.annotations.SerializedName

data class Players(@SerializedName("all_players") val allPlayers : List<Player>)
