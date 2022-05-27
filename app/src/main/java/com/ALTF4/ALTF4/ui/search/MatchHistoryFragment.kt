package com.ALTF4.ALTF4.ui.search

import android.media.Image
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.ALTF4.ALTF4.R
import com.ALTF4.ALTF4.databinding.MatchHistoryFragmentBinding
import com.ALTF4.ALTF4.databinding.ProfileFragmentBinding
import com.squareup.picasso.Picasso
import com.ALTF4.ALTF4.GlobalClass as GLOBAL

class MatchHistoryFragment : Fragment() {
    private lateinit var matchhistoryViewModel: MatchHistoryViewModel
    private var _binding: MatchHistoryFragmentBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = MatchHistoryFragment()
    }

    private lateinit var viewModel: MatchHistoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MatchHistoryFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val uname  =  GLOBAL.Player?.accountData?.data?.name.toString()
        val tag = GLOBAL.Player?.accountData?.data?.tag.toString()
       val mh_username = root.findViewById<TextView>(R.id.MH_UserTXT)
        val mh_tag = root.findViewById<TextView>(R.id.MH_TagTXT)
        mh_username.text = uname
        mh_tag.text = "#" + tag
        SetUI(root)
        return root
    }

        fun SetUI(root : View){
            var global = GLOBAL.Player
          var player =  GLOBAL.Player?.matchHistData?.data?.get(0)?.players?.allPlayers?.filter { it.name == GLOBAL.Player?.accountData?.data?.name }?.get(0)
            //var hasWon = GLOBAL.Player.matchHistData.data.get(0).teams.blue

            var mode1 = global?.matchHistData?.data?.get(0)?.metadata?.mode.toString()
            var map1 = global?.matchHistData?.data?.get(0)?.metadata?.map.toString()
            var rounds1 = global?.matchHistData?.data?.get(0)?.metadata?.totalRound.toString()
            var kills1 = player?.stats?.kills.toString()
            var deaths1 = player?.stats?.deaths.toString()
            var assists1 = player?.stats?.assists.toString()
            var agentUI1 = root.findViewById<ImageView>(R.id.agent1)
            var matchinfoTXT1 = root.findViewById<TextView>(R.id.matchinfo1)
            var match1 = root.findViewById<ImageView>(R.id.match1bg)
            match1.setImageResource(R.drawable.defeat_rec)
            var match1title = root.findViewById<TextView>(R.id.match1title)
            match1title.text = mode1
            matchinfoTXT1.text = map1+"\nTotal Rounds:"+rounds1+"\n"+kills1+"/"+deaths1+"/"+assists1+" KDA"
            var agent_pic1 = player?.assets?.agent?.agentPicture.toString()
            Picasso.get()
                .load(agent_pic1)
                .resize(250, 250)  // h416    w164
                .centerCrop()
                .into(agentUI1)

            player =  GLOBAL.Player?.matchHistData?.data?.get(1)?.players?.allPlayers?.filter { it.name == GLOBAL.Player?.accountData?.data?.name }?.get(0)
            var mode2 = global?.matchHistData?.data?.get(1)?.metadata?.mode.toString()
            var map2 = global?.matchHistData?.data?.get(1)?.metadata?.map.toString()
            var rounds2 = global?.matchHistData?.data?.get(1)?.metadata?.totalRound.toString()
            var kills2 = player?.stats?.kills.toString()
            var deaths2 = player?.stats?.deaths.toString()
            var assists2 = player?.stats?.assists.toString()
            var agentUI2 = root.findViewById<ImageView>(R.id.agent2)
            var matchinfoTXT2 = root.findViewById<TextView>(R.id.matchinfo2)
            var match2 = root.findViewById<ImageView>(R.id.match2bg)
            match2.setImageResource(R.drawable.defeat_rec)
            var match2title = root.findViewById<TextView>(R.id.match2title)
            match2title.text = mode2
            matchinfoTXT2.text = map2+"\nTotal Rounds:"+rounds2+"\n"+kills2+"/"+deaths2+"/"+assists2+" KDA"
            var agent_pic2 = player?.assets?.agent?.agentPicture.toString()
            Picasso.get()
                .load(agent_pic2)
                .resize(250, 250)  // h416    w164
                .centerCrop()
                .into(agentUI2)

            player =  GLOBAL.Player?.matchHistData?.data?.get(2)?.players?.allPlayers?.filter { it.name == GLOBAL.Player?.accountData?.data?.name }?.get(0)
            var mode3 = global?.matchHistData?.data?.get(2)?.metadata?.mode.toString()
            var map3 = global?.matchHistData?.data?.get(2)?.metadata?.map.toString()
            var rounds3 = global?.matchHistData?.data?.get(2)?.metadata?.totalRound.toString()
            var kills3 = player?.stats?.kills.toString()
            var deaths3 = player?.stats?.deaths.toString()
            var assists3 = player?.stats?.assists.toString()
            var agentUI3 = root.findViewById<ImageView>(R.id.agent3)
            var matchinfoTXT3 = root.findViewById<TextView>(R.id.matchinfo3)
            var match3 = root.findViewById<ImageView>(R.id.match3bg)
            match3.setImageResource(R.drawable.defeat_rec)
            var match3title = root.findViewById<TextView>(R.id.match3title)
            match3title.text = mode3
            matchinfoTXT3.text = map3+"\nTotal Rounds:"+rounds3+"\n"+kills3+"/"+deaths3+"/"+assists3+" KDA"
            var agent_pic3 = player?.assets?.agent?.agentPicture.toString()
            Picasso.get()
                .load(agent_pic3)
                .resize(250, 250)  // h416    w164
                .centerCrop()
                .into(agentUI3)

            player =  GLOBAL.Player?.matchHistData?.data?.get(3)?.players?.allPlayers?.filter { it.name == GLOBAL.Player?.accountData?.data?.name }?.get(0)
            var mode4 = global?.matchHistData?.data?.get(3)?.metadata?.mode.toString()
            var map4 = global?.matchHistData?.data?.get(3)?.metadata?.map.toString()
            var rounds4 = global?.matchHistData?.data?.get(3)?.metadata?.totalRound.toString()
            var kills4 = player?.stats?.kills.toString()
            var deaths4 = player?.stats?.deaths.toString()
            var assists4 = player?.stats?.assists.toString()
            var agentUI4 = root.findViewById<ImageView>(R.id.agent4)
            var matchinfoTXT4 = root.findViewById<TextView>(R.id.matchinfo4)
            var match4 = root.findViewById<ImageView>(R.id.match4bg)
            match4.setImageResource(R.drawable.defeat_rec)
            var match4title = root.findViewById<TextView>(R.id.match4title)
            match4title.text = mode4
            matchinfoTXT4.text = map4+"\nTotal Rounds:"+rounds4+"\n"+kills4+"/"+deaths4+"/"+assists4+" KDA"
            var agent_pic4 = player?.assets?.agent?.agentPicture.toString()
            Picasso.get()
                .load(agent_pic4)
                .resize(250, 250)  // h416    w164
                .centerCrop()
                .into(agentUI4)

            player =  GLOBAL.Player?.matchHistData?.data?.get(4)?.players?.allPlayers?.filter { it.name == GLOBAL.Player?.accountData?.data?.name }?.get(0)
            var mode5 = global?.matchHistData?.data?.get(4)?.metadata?.mode.toString()
            var map5 = global?.matchHistData?.data?.get(4)?.metadata?.map.toString()
            var rounds5 = global?.matchHistData?.data?.get(4)?.metadata?.totalRound.toString()
            var kills5 = player?.stats?.kills.toString()
            var deaths5 = player?.stats?.deaths.toString()
            var assists5 = player?.stats?.assists.toString()
            var agentUI5 = root.findViewById<ImageView>(R.id.agent5)
            var matchinfoTXT5 = root.findViewById<TextView>(R.id.matchinfo5)
            var match5 = root.findViewById<ImageView>(R.id.match5bg)
            match5.setImageResource(R.drawable.defeat_rec)
            var match5title = root.findViewById<TextView>(R.id.match5title)
            match5title.text = mode5
            matchinfoTXT5.text = map5+"\nTotal Rounds:"+rounds5+"\n"+kills5+"/"+deaths5+"/"+assists5+" KDA"
            var agent_pic5 = player?.assets?.agent?.agentPicture.toString()
            Picasso.get()
                .load(agent_pic5)
                .resize(250, 250)  // h416    w164
                .centerCrop()
                .into(agentUI5)

        }

}