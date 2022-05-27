package com.ALTF4.ALTF4.models

import com.ALTF4.ALTF4.models.accountdata.AccountInfo
import com.ALTF4.ALTF4.models.matchhistorydata.MatchHistoryInfo
import com.ALTF4.ALTF4.models.mmrdata.MmrInfo
import com.ALTF4.ALTF4.models.rankimagedata.RankImageInfo

data class Player(var accountData : AccountInfo, var mmrData : MmrInfo, var rankImgData : RankImageInfo, var matchHistData : MatchHistoryInfo)
