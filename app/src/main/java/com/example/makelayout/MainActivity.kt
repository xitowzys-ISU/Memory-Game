package com.example.makelayout

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(applicationContext)
        layout.orientation = LinearLayout.VERTICAL

        val params = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT)
        params.weight = 1.toFloat()

        val catViews = ArrayList<ImageView>()
        for (n in 1..16) {
            catViews.add(ImageView(applicationContext).apply {
                setImageResource(R.drawable.squarecat)
                layoutParams = params
            })
        }

        val rows = ArrayList<LinearLayout>();

        for (i in 1..4) {
            rows.add(LinearLayout(applicationContext).apply {
                orientation = LinearLayout.HORIZONTAL
                setBackgroundColor(Color.GRAY)
                for (j in 1..4) addView(catViews[(i - 1) * 4 + (j - 1)])

            }
            )
        }

        for (row in rows) layout.addView(row)

        setContentView(layout)
    }
}