package com.hmproductions.motional

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.helper.widget.Carousel
import androidx.constraintlayout.utils.widget.ImageFilterView

class CarouselActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carousel)

        val images = listOf(
            R.drawable.bryce_canyon,
            R.drawable.cathedral_rock,
            R.drawable.death_valley,
            R.drawable.fitzgerald_marine_reserve,
            R.drawable.goldengate,
            R.drawable.grand_canyon
        )

        setupCarousel(images)
    }

    private fun setupCarousel(images: List<Int>) {
        val carousel = findViewById<Carousel>(R.id.carousel)

        carousel.setAdapter(object : Carousel.Adapter {
            override fun count(): Int {
                return images.size
            }

            override fun populate(view: View, index: Int) {
                val imageView = view as? ImageFilterView ?: return
                imageView.setImageResource(images[index])
            }

            override fun onNewItem(index: Int) {
                // Do nothing
            }
        })
    }
}