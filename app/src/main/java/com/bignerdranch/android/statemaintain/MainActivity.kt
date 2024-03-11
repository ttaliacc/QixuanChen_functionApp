package com.bignerdranch.android.statemaintain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        imageView = findViewById(R.id.imageView)

        button.setOnClickListener {
            generateImage()
        }
    }
    private fun generateImage() {
        val randomImageId = resources.getIdentifier("cat${Random.nextInt(1, 11)}", "drawable", packageName)
        imageView.setImageResource(randomImageId)
    }
}