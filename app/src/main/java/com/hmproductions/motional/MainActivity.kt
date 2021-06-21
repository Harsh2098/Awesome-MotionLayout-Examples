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
            binding.bonusExampleButton to NotificationPanelActivity::class.java,
            binding.geometryExampleButton to GeometryActivity::class.java
        )

        buttonMapping.forEach { (button, activity) ->
            button.setOnClickListener { startActivity(Intent(this, activity)) }
        }

        binding.superBonusExampleButton.setOnClickListener {
            openSGBusesDebug()
        }

        binding.superBonusExampleButton.setOnLongClickListener {
            val intent = Intent(this, CarouselActivity::class.java)
            startActivity(intent)
            true
        }
    }

    private fun openSGBusesDebug() {
        packageManager.getLaunchIntentForPackage("com.hmproductions.sgbuses").let {
            if(it != null) {
                startActivity(it)
                return
            }
        }

        packageManager.getLaunchIntentForPackage("com.hmproductions.sgbuses.debug")?.let {
            startActivity(it)
        }
    }
}