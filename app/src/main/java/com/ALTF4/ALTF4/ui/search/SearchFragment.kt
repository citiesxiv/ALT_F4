package com.ALTF4.ALTF4.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.*
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.ALTF4.ALTF4.R
import com.ALTF4.ALTF4.apilib.ApiLib
import com.ALTF4.ALTF4.databinding.FragmentSearchBinding
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import com.ALTF4.ALTF4.GlobalClass as GLOBAL

class SearchFragment : Fragment() {

    private lateinit var searchViewModel: SearchViewModel
    private var _binding: FragmentSearchBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    val ActivityRef = activity

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        searchViewModel =
            ViewModelProvider(this).get(SearchViewModel::class.java)

        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val root: View = binding.root
        root.findViewById<View>(R.id.SearchBTN).setOnClickListener{

            //Disable the button to stop spam
            var thisBtn : ImageButton = root.findViewById(R.id.SearchBTN)
            thisBtn.isEnabled = false

            //Init vars
            var apiLib = ApiLib()

            //Bind to UI
            val usernametxt: TextView = root.findViewById(R.id.UserNameTxt)
            val tagtxt : TextView = root.findViewById(R.id.TagTxt)

            //Get data
            val username = usernametxt.text.toString()
            val tag = tagtxt.text.toString()
            val region = "na"

            if(username == "" || tag == ""){
                Toast.makeText(context, "Username or Tag cannot be empty!" ,Toast.LENGTH_LONG).show()
                thisBtn.isEnabled = true
            }else{
                //Run API CALL then navigate to profile fragment
                CoroutineScope(Main).launch {
                    GLOBAL.Player = async(IO) { apiLib.buildPlayerProfileV2(username, tag, region) }.await()
                    if(GLOBAL.Player?.accountData?.status == 200 && GLOBAL.Player?.mmrData?.status == 200 && GLOBAL.Player?.matchHistData?.status == 200){
                        Navigation.findNavController(root).navigate(R.id.action_navigation_search_to_profileFragment)
                    }else if(GLOBAL.Player?.accountData?.status == 404){
                        Toast.makeText(context, GLOBAL.Player?.accountData?.message ,Toast.LENGTH_LONG).show()
                        thisBtn.isEnabled = true
                    }else{
                        Toast.makeText(context, "ALT+F4 encountered an error while fetching your data\nPlease try again shortly\n\n${GLOBAL.Player?.accountData?.message}" ,Toast.LENGTH_LONG).show()
                        thisBtn.isEnabled = true
                    }
                }
            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun navigateToProfile(root : View){
        if(GLOBAL.Player != null){
            Toast.makeText(ActivityRef, GLOBAL.Player?.accountData?.data?.name ,Toast.LENGTH_LONG).show()
            Navigation.findNavController(root).navigate(R.id.action_navigation_search_to_profileFragment)
        }else{
            Toast.makeText(ActivityRef, "There was an error fetching your data, please try again" ,Toast.LENGTH_LONG).show()
        }
    }
}