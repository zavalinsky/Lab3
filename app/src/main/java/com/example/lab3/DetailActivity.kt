package com.example.lab3

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imageRes = intent.getIntExtra("image_res", 0)
        val title = intent.getStringExtra("title") ?: ""
        val fullDesc = intent.getStringExtra("full_desc") ?: ""

        findViewById<ImageView>(R.id.iv_detail_image).setImageResource(imageRes)
        findViewById<TextView>(R.id.tv_detail_title).text = title
        findViewById<TextView>(R.id.tv_detail_full_desc).text = fullDesc

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}