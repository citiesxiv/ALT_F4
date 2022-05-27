package com.ALTF4.ALTF4.models.matchhistorydata


import com.google.gson.annotations.SerializedName

data class MyMetadata(val map : String,
                      @SerializedName("rounds_played") val totalRound : Int,
                      val mode : String
                    )
