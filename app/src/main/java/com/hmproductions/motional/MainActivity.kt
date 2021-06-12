package com.hmproductions.motional

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.hmproductions.motional.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val buttonMapping = mapOf(
            binding.galleryExampleButton to GalleryActivity::class.java,
            binding.magnetExampleButton to MagnetActivity::class.java,
            binding.bonusExampleButton to BonusActivity::class.java
        )

        buttonMapping.forEach { (button, activity) ->
            button.setOnClickListener { startActivity(Intent(this, activity)) }
        }

        binding.superBonusExampleButton.setOnClickListener {
            openSGBusesDebug()
        }
    }

    private fun openSGBusesDebug() {
        val launchIntent = packageManager.getLaunchIntentForPackage("com.hmproductions.sgbuses.debug")
        launchIntent?.let { startActivity(it) }
    }
}