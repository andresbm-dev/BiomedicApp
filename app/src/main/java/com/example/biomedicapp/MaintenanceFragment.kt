package com.example.biomedicapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.biomedicapp.databinding.FragmentMaintenanceBinding


class MaintenanceFragment : Fragment() {

    lateinit var binding: FragmentMaintenanceBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMaintenanceBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }


}