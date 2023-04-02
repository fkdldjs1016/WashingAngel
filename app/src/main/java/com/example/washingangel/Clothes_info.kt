package com.example.washingangel

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.provider.MediaStore
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.washingangel.databinding.ClothesInfoBinding

class Clothes_info : Fragment() {
    private lateinit var binding: ClothesInfoBinding
    private val REQUEST_IMAGE_CAPTURE = 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = ClothesInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up the spinner for clothes type
        val clothesType = resources.getStringArray(R.array.clothes_array)
        val clothesTypeAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, clothesType)
        binding.spinner2.adapter = clothesTypeAdapter

        // Set up the spinner for clothes color
        val clothesColor = resources.getStringArray(R.array.color_array)
        val clothesColorAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, clothesColor)
        binding.spinner33.adapter = clothesColorAdapter

        // Set up image button to launch camera intent
        binding.icon1.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            binding.icon1.setImageBitmap(imageBitmap)
        }
    }
}
