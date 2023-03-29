package com.example.washingangel

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.washingangel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(WashTag())

        val settingBtn = findViewById<ImageButton>(R.id.setting_button)

        settingBtn.setOnClickListener(this)


        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){

                R.id.closet -> replaceFragment(WashTag())
                R.id.machine -> replaceFragment(Closet())
                R.id.camera -> replaceFragment(Camera())
                R.id.tips -> replaceFragment(Tips())
                R.id.basket -> replaceFragment(Basket())

                else ->{
                }
            }

            true
        }
    }

    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()

    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.setting_button -> replaceFragment(Setting())

        }
    }
}


