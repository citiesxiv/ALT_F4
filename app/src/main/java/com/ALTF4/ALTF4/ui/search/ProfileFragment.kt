package com.ALTF4.ALTF4.ui.search

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import com.ALTF4.ALTF4.R
import com.ALTF4.ALTF4.databinding.ProfileFragmentBinding
import com.squareup.picasso.Picasso
import com.ALTF4.ALTF4.GlobalClass as GLOBAL

class ProfileFragment : Fragment() {

    private lateinit var profileViewModel: ProfileViewModel
    private var _binding: ProfileFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        profileViewModel =
            ViewModelProvider(this).get(ProfileViewModel::class.java)

        _binding = ProfileFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //Bind to UI
        val usernameUI: TextView = root.findViewById(R.id.profile_usernameTXT)
        val tagUI: TextView = root.findViewById(R.id.profile_TagTXT)
        val profileimgUI: ImageView = root.findViewById(R.id.profile_userprofileIMG)
        val rankimgUI : ImageView = root.findViewById(R.id.profile_userrankIMG)
        val rankUI: TextView = root.findViewById(R.id.profile_rankTXT)


        //Local vars
        var username: String = GLOBAL.Player?.accountData?.data?.name.toString()
        var tag: String ="#" + GLOBAL.Player?.accountData?.data?.tag.toString()
        var profileimg: String = GLOBAL.Player?.accountData?.data?.card?.large.toString()
        var rank: String = GLOBAL.Player?.mmrData?.data?.currenttierpatched.toString()
        var rankimg: String = GLOBAL.Player?.rankImgData?.data?.tiers?.get(GLOBAL.Player?.mmrData?.data?.currenttier!!)?.largeIcon.toString()


        //Set UI Values
        usernameUI.text = username
        tagUI.text = tag
        rankUI.text = rank

        Picasso.get()
            .load(profileimg)
            .resize(656, 1664)  // h416    w164
            .centerCrop()
            .into(profileimgUI)
        Picasso.get()
            .load(rankimg)
            .resize(350, 350)
            .centerCrop()
            .into(rankimgUI)

        root.findViewById<ImageButton>(R.id.MatchHistoryBTN).setOnClickListener{
            Navigation.findNavController(root).navigate(R.id.action_profileFragment_to_matchHistoryFragment)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}