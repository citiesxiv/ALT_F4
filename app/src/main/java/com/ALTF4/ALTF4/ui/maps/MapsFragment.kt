package com.ALTF4.ALTF4.ui.maps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.ALTF4.ALTF4.R
import com.ALTF4.ALTF4.databinding.FragmentMapsBinding

class MapsFragment : Fragment() {

    private lateinit var mapsViewModel: MapsViewModel
    private var _binding: FragmentMapsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mapsViewModel =
            ViewModelProvider(this).get(MapsViewModel::class.java)

        _binding = FragmentMapsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        root.findViewById<View>(R.id.Havenbtn).setOnClickListener{
            Navigation.findNavController(root).navigate(R.id.action_navigation_maps_to_havenFragment)
        }
        root.findViewById<View>(R.id.Splitbtn).setOnClickListener{
            Navigation.findNavController(root).navigate(R.id.action_navigation_maps_to_splitFrgament)
        }
        root.findViewById<View>(R.id.Bindbtn).setOnClickListener{
            Navigation.findNavController(root).navigate(R.id.action_navigation_maps_to_bindFragment)
        }
        root.findViewById<View>(R.id.IceBoxbtn).setOnClickListener{
            Navigation.findNavController(root).navigate(R.id.action_navigation_maps_to_iceBoxFragment)
        }
        root.findViewById<View>(R.id.Fracturebtn).setOnClickListener{
            Navigation.findNavController(root).navigate(R.id.action_navigation_maps_to_fractureFragment)
        }
        root.findViewById<View>(R.id.Breezebtn).setOnClickListener{
            Navigation.findNavController(root).navigate(R.id.action_navigation_maps_to_breezeFragment)
        }
        root.findViewById<View>(R.id.Ascentbtn).setOnClickListener{
            Navigation.findNavController(root).navigate(R.id.action_navigation_maps_to_ascentFragment)
        }



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}