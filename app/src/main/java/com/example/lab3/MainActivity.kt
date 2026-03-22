package com.example.lab3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TipsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rv_tips)
        val tips = generateTipsList()
        adapter = TipsAdapter(tips) { tip ->
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("image_res", tip.imageResId)
                putExtra("title", tip.title)
                putExtra("full_desc", tip.fullDescription)
            }
            startActivity(intent)
        }
        recyclerView.adapter = adapter
    }

    private fun generateTipsList(): List<Tip> {
        val resources = resources
        val shortDescriptions = resources.getStringArray(R.array.short_descriptions)
        val fullDescriptions = resources.getStringArray(R.array.full_descriptions)

        // Список ресурсов изображений (замените на ваши имена drawable)
        val imageIds = listOf(
            R.drawable.ic_day_1, R.drawable.ic_day_2, R.drawable.ic_day_3,
            R.drawable.ic_day_4, R.drawable.ic_day_5, R.drawable.ic_day_6,
            R.drawable.ic_day_7, R.drawable.ic_day_8, R.drawable.ic_day_9,
            R.drawable.ic_day_10, R.drawable.ic_day_11, R.drawable.ic_day_12,
            R.drawable.ic_day_13, R.drawable.ic_day_14, R.drawable.ic_day_15,
            R.drawable.ic_day_16, R.drawable.ic_day_17, R.drawable.ic_day_18,
            R.drawable.ic_day_19, R.drawable.ic_day_20, R.drawable.ic_day_21,
            R.drawable.ic_day_22, R.drawable.ic_day_23, R.drawable.ic_day_24,
            R.drawable.ic_day_25, R.drawable.ic_day_26, R.drawable.ic_day_27,
            R.drawable.ic_day_28, R.drawable.ic_day_29, R.drawable.ic_day_30
        )

        val tips = mutableListOf<Tip>()
        for (i in 0 until 30) {
            val day = i + 1
            val title = "Совет дня $day" // можно тоже вынести в ресурсы
            val shortDesc = shortDescriptions[i]
            val fullDesc = fullDescriptions[i]
            val imageId = imageIds[i]
            tips.add(Tip(day, title, shortDesc, fullDesc, imageId))
        }
        return tips
    }
}