package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import com.example.colormyviews.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers.Main

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        disableDarkMode()

        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.setListeners()

        setContentView(binding.root)
    }

    private fun ActivityMainBinding.setListeners() {
        boxOneText.addColorListener { setBackgroundColor(Color.DKGRAY) }
        boxTwoText.addColorListener { setBackgroundColor(Color.DKGRAY) }

        boxThreeText.addColorListener { setBackgroundResource(android.R.color.holo_green_light) }
        boxFourText.addColorListener { setBackgroundResource(android.R.color.holo_green_dark) }
        boxFiveText.addColorListener { setBackgroundResource(android.R.color.holo_green_light) }

        redButton.addColorListener { boxThreeText.setBackgroundResource(R.color.my_red) }
        yellowButton.addColorListener { boxFourText.setBackgroundResource(R.color.my_yellow) }
        greenButton.addColorListener { boxFiveText.setBackgroundResource(R.color.my_green) }
    }

    private fun <T: View> T.addColorListener(action: T.() -> Unit) {
        this.setOnClickListener { action() }
    }

    private fun disableDarkMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}