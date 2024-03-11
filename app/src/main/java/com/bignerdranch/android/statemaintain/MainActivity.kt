package com.bignerdranch.android.statemaintain

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var imageView: ImageView
    private lateinit var editText: EditText
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        imageView = findViewById(R.id.imageView)
        editText = findViewById(R.id.editTextText)

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        val savedImage = sharedPreferences.getInt("imageKey", 0)
        if (savedImage != 0) {
            imageView.setImageResource(savedImage)
        }
        val savedText = sharedPreferences.getString("textKey", "")
        editText.setText(savedText)

        button.setOnClickListener {
            generateImage()
        }
    }
    private fun generateImage() {
        val randomImageName = "icon${Random.nextInt(1, 11)}"
        val randomImageId = resources.getIdentifier(randomImageName, "drawable", packageName)
        imageView.setImageResource(randomImageId)

        val editor = sharedPreferences.edit()
        editor.putInt("imageKey", randomImageId)
        editor.apply()
    }

    override fun onDestroy() {
        super.onDestroy()
        val editor = sharedPreferences.edit()
        editor.putString("textKey", editText.text.toString())
        editor.apply()
    }

}