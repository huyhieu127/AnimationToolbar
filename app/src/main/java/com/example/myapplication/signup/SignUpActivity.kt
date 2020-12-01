package com.example.myapplication.signup

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_sign_up.*


class SignUpActivity : AppCompatActivity() {
    private var valueCurrent = 0
    private lateinit var anim01: ObjectAnimator
    private lateinit var anim12: ObjectAnimator
    private lateinit var anim23: ObjectAnimator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        anim01 = ObjectAnimator.ofInt(prgSteps, "progress", valueCurrent, 33)
        anim01.duration = 500
        anim01.start()
        fabNext.setOnClickListener {
            valueCurrent = prgSteps.progress
            anim12 = ObjectAnimator.ofInt(prgSteps, "progress", valueCurrent, 66)
            anim12.duration = 500
            anim23 = ObjectAnimator.ofInt(prgSteps, "progress", valueCurrent, 100)
            anim23.duration = 500
            if (anim01.isRunning) {
                anim01.cancel()
            }
            if (anim12.isRunning) {
                anim12.cancel()
            }
            if (anim23.isRunning) {
                anim23.cancel()
            }
            if (findNavController(R.id.nav_host_fragment).currentDestination?.id == R.id.s1Fragment) {
                findNavController(R.id.nav_host_fragment).navigate(R.id.action_s1Fragment_to_s2Fragment)
                anim12.start()
            } else if (findNavController(R.id.nav_host_fragment).currentDestination?.id == R.id.s2Fragment) {
                findNavController(R.id.nav_host_fragment).navigate(R.id.action_s2Fragment_to_s3Fragment)
                anim23.start()
            }
        }
    }

    override fun onBackPressed() {
        valueCurrent = prgSteps.progress
        anim12 = ObjectAnimator.ofInt(prgSteps, "progress", valueCurrent, 66)
        anim12.duration = 500
        anim01 = ObjectAnimator.ofInt(prgSteps, "progress", valueCurrent, 33)
        anim01.duration = 500
        if (anim01.isRunning) {
            anim01.cancel()
        }
        if (anim12.isRunning) {
            anim12.cancel()
        }
        if (anim23.isRunning) {
            anim23.cancel()
        }
        if (findNavController(R.id.nav_host_fragment).currentDestination?.id == R.id.s2Fragment) {
            anim01.start()
        } else if (findNavController(R.id.nav_host_fragment).currentDestination?.id == R.id.s3Fragment) {
            anim12.start()
        }
        super.onBackPressed()
    }
}