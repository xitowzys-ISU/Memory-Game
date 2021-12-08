package com.example.makelayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val cat = ImageView(applicationContext)
        cat.setImageResource(R.drawable.squarecat)

        val layout = LinearLayout(applicationContext)
        layout.orientation = LinearLayout.VERTICAL
        layout.addView(cat)

        val cat2 = ImageView(applicationContext)
        cat2.setImageResource(R.drawable.squarecat)
        layout.addView(cat2)

        setContentView(layout)
        //setContentView(R.layout.activity_main)
    }
}