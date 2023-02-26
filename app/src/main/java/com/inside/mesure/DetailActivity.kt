package com.inside.mesure

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        fullScreen()

        val idMeSure = intent.getIntExtra("id", 0)

        val nameTextView: TextView = findViewById(R.id.nameTextView)
        val dateTextView: TextView = findViewById(R.id.dateTextView)
        val ratingTextView: TextView = findViewById(R.id.ratingTextView)
        val descriptionTextView: TextView = findViewById(R.id.descriptionTextView)
        val posterImageView: ImageView = findViewById(R.id.posterImageView)

        nameTextView.text = resources.getStringArray(R.array.name)[idMeSure]
        dateTextView.text = resources.getStringArray(R.array.date)[idMeSure]
        ratingTextView.text = resources.getStringArray(R.array.rating)[idMeSure]
        descriptionTextView.text = resources.getStringArray(R.array.description)[idMeSure]

        Glide.with(this)
            .load(resources.getStringArray(R.array.url)[idMeSure])
            .into(posterImageView)
    }

    private fun fullScreen() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
            val controller = window.insetsController
            if (controller != null) {
                controller.hide(WindowInsets.Type.navigationBars())
                controller.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        } else {
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
        }
    }
}