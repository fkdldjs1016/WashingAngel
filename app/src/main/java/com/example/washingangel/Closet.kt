package com.example.washingangel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.washingangel.databinding.FragmentClosetBinding

class Closet : Fragment() {
    private lateinit var binding: FragmentClosetBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentClosetBinding.inflate(inflater, container, false)

        binding.icon1.setOnClickListener {
            val clothesInfoFragment = Clothes_info()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, clothesInfoFragment)
                .addToBackStack(null)
                .commit()
        }

        return binding.root
    }
}
