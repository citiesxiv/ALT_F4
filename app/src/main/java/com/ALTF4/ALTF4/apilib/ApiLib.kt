package com.ALTF4.ALTF4.apilib

import com.google.gson.Gson
import com.ALTF4.ALTF4.models.accountdata.AccountInfo
import com.ALTF4.ALTF4.models.matchhistorydata.MatchHistoryInfo
import com.ALTF4.ALTF4.models.mmrdata.MmrInfo
import com.ALTF4.ALTF4.models.rankimagedata.RankImageInfo
import okhttp3.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main
import com.ALTF4.ALTF4.models.Player as Player

class ApiLib{

    private val client = OkHttpClient()



    private fun callApiV2(url: String) : String?{
        var result : String? = null
        try{
            val request = Request.Builder().url(url).build()
            val response = client.newCall(request).execute()
            result = response.body?.string()
        }
        catch (err: Exception){
            println("Error encountered during API call! \n $err")
        }
        return result
    }

    suspend fun buildPlayerProfileV2(userName: String, tag: String, region: String): Player? {

        val profileURL = "https://api.henrikdev.xyz/valorant/v1/account/${userName}/${tag}"
        val mmrURL = "https://api.henrikdev.xyz/valorant/v1/mmr/$region/$userName/$tag"
        val matchHistoryURL = "https://api.henrikdev.xyz/valorant/v3/matches/$region/$userName/$tag"
        val rankImageURL = "https://valorant-api.com/v1/competitivetiers/e4e9a692-288f-63ca-7835-16fbf6234fda"

        var accountInfo : AccountInfo? = null
        var mmrInfo : MmrInfo? = null
        var matchHistoryInfo : MatchHistoryInfo? = null
        var rankImageInfo : RankImageInfo? = null
        var player : Player? = null

        coroutineScope {
            try {
                val accountData = async { callApiV2(profileURL) }
                val mmrData = async { callApiV2(mmrURL) }
                val matchHistoryData = async { callApiV2(matchHistoryURL) }
                val rankImageData = async { callApiV2(rankImageURL) }

                val accountDataObj = async { Gson().fromJson(accountData.await(), AccountInfo::class.java) }
                val mmrDataObj = async { Gson().fromJson(mmrData.await(), MmrInfo::class.java) }
                val histDataObj = async { Gson().fromJson(matchHistoryData.await(), MatchHistoryInfo::class.java) }
                val rankImageObj = async { Gson().fromJson(rankImageData.await(), RankImageInfo::class.java) }

                player = Player(accountDataObj.await(), mmrDataObj.await(), rankImageObj.await() , histDataObj.await())
            }
            catch (err : Exception){
                println("Error encountered during Player object build! \n $err")
            }
        }
        //Return constructed player object
        return player
    }
}