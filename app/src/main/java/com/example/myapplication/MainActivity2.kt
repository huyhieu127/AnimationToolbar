package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.NestedScrollView
import com.example.myapplication.signup.SignUpActivity
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        cvNotification.setOnClickListener {}
        cvSearch.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
        fabSwap.setOnClickListener {
            startActivity(Intent(this, MainActivity1::class.java))
            finish()
        }
    }
}