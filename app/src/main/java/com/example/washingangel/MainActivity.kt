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
                R.id.machine -> {
                    replaceFragment(WashTag())
                    binding.toolbarTitle.text = getString(R.string.wash_tag_title)
                }
                R.id.closet -> {
                    replaceFragment(Closet())
                    binding.toolbarTitle.text = getString(R.string.closet_title)
                }
                R.id.camera -> {
                    replaceFragment(Camera())
                    binding.toolbarTitle.text = getString(R.string.camera_title)
                }
                R.id.tips -> {
                    replaceFragment(Tips())
                    binding.toolbarTitle.text = getString(R.string.tips_title)
                }
                R.id.basket -> {
                    replaceFragment(Basket())
                    binding.toolbarTitle.text = getString(R.string.basket_title)
                }
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
            R.id.setting_button -> {
                replaceFragment(Setting())
                binding.toolbarTitle.text = getString(R.string.setting_title)
            }
        }
    }
}


