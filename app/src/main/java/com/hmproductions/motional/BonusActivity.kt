package com.hmproductions.motional

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.hmproductions.motional.databinding.ActivityBonusBinding

class BonusActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBonusBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bonus)

        binding.resetFab.setOnClickListener {
            binding.bonusMotionLayout.transitionToStart()
        }
    }
}