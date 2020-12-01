package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import com.example.myapplication.signup.SignUpActivity
import kotlinx.android.synthetic.main.activity_main1.*


class MainActivity1 : AppCompatActivity() {
    private var hTab: Int = 0
    private var yTab: Int = 0
    private var yToolBar: Int = 0
    private var hToolBar: Int = 0
    private var xCvArea: Int = 0
    private var yCvArea: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)
        //setFullScreen()
        lnTabBar.post {
            val location = IntArray(2)
            lnTabBar.getLocationInWindow(location)
            yTab = location[1]
            hTab = lnTabContent.height
        }
        cvArea.post {
            val location = IntArray(2)
            cvArea.getLocationInWindow(location)
            xCvArea = location[0]
            yCvArea = location[1]
        }
        vToolBar.post {
            val location = IntArray(2)
            vToolBar.getLocationInWindow(location)
            hToolBar = vToolBar.height
            yToolBar = location[1]
        }

        nsvMain.setOnScrollChangeListener(
            NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
                run {
                    tvArea.post {
                        val location = IntArray(2)
                        tvArea.getLocationInWindow(location)

                        if (location[1] > yToolBar + hToolBar) {
                            if (cvArea.visibility == View.VISIBLE) {
                                val animation =
                                    AnimationUtils.loadAnimation(this@MainActivity1, R.anim.fade_out)
                                cvArea.animation = animation
                                cvArea.visibility = View.INVISIBLE
                                val anim =
                                    AnimationUtils.loadAnimation(this@MainActivity1, R.anim.fade_in)
                                tvArea.animation = anim
                                tvArea.visibility = View.VISIBLE
                            }
                        } else {
                            if (scrollY < oldScrollY && location[1] + tvArea.height > yToolBar + hToolBar) {
                                if (cvArea.visibility == View.VISIBLE) {
                                    val animation =
                                        AnimationUtils.loadAnimation(
                                            this@MainActivity1,
                                            R.anim.fade_out
                                        )
                                    cvArea.animation = animation
                                    cvArea.visibility = View.INVISIBLE
                                    val anim =
                                        AnimationUtils.loadAnimation(
                                            this@MainActivity1,
                                            R.anim.fade_in
                                        )
                                    tvArea.animation = anim
                                    tvArea.visibility = View.VISIBLE
                                }
                            } else if (cvArea.visibility == View.INVISIBLE) {
                                val animation =
                                    AnimationUtils.loadAnimation(
                                        this@MainActivity1,
                                        R.anim.show_title
                                    )
                                cvArea.animation = animation
                                cvArea.visibility = View.VISIBLE

                                val anim =
                                    AnimationUtils.loadAnimation(
                                        this@MainActivity1,
                                        R.anim.fade_out
                                    )
                                tvArea.animation = anim
                                tvArea.visibility = View.INVISIBLE
                            }
                        }
                    }

                    lnTabContent.post {
                        val location = IntArray(2)
                        lnTabContent.getLocationInWindow(location)
                        if (location[1] > yTab) {
                            lnTabBar.visibility = View.INVISIBLE
                        } else {
                            lnTabBar.visibility = View.VISIBLE
                        }
                    }

                }
            }
        )

        cvNotification.setOnClickListener {}
        cvSearch.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
        fabSwap.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
            finish()
        }
    }
}