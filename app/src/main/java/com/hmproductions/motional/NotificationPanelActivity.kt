package com.hmproductions.motional

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import com.google.android.material.snackbar.Snackbar

class NotificationPanelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification_panel)

        findViewById<MotionLayout>(R.id.notificationPanelMotionLayout).addTransitionListener(object :
            MotionLayout.TransitionListener {
            override fun onTransitionTrigger(
                layout: MotionLayout,
                triggerId: Int,
                positive: Boolean,
                progress: Float
            ) {
                if (triggerId == R.id.centralFabTrigger) {
                    showProgressSnackbar(
                        findViewById(android.R.id.content),
                        if (positive) "Forward" else "Backward"
                    )
                }
            }

            override fun onTransitionStarted(p0: MotionLayout, p1: Int, p2: Int) {}
            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {}
            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {}
        })
    }

    private fun showProgressSnackbar(view: View, extra: String) {
        Snackbar.make(view, "$extra transition completion 50%", Snackbar.LENGTH_SHORT).show()
    }
}