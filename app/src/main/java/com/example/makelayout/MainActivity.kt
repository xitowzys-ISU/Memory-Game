package com.example.makelayout

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.makelayout.Game.Game

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val game = Game(4, applicationContext)

//        val layout = LinearLayout(applicationContext)
//        layout.orientation = LinearLayout.VERTICAL
//
//        val params = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT)
//        params.weight = 1.toFloat()
//
//        // TODO: 3) реализовать переворот карт с "рубашки" на лицевую сторону и обратно
//        val colorListener = View.OnClickListener {
//            it.setBackgroundColor(Color.YELLOW)
//        }
//
//        // TODO: 2) случайным образом разместить 8 пар картинок
//        val catViews = ArrayList<ImageView>()
//        for (n in 1..16) {
//            catViews.add(ImageView(applicationContext).apply {
//                setImageResource(R.drawable.squarecat)
//                layoutParams = params
//                setOnClickListener(colorListener)
//            })
//        }
//
//        // TODO: 1) заполнить 4 строки элементами из массива catViews по 4 штуки в ряду
//        val rows: Array<LinearLayout> = Array(4) {
//            LinearLayout(applicationContext).apply {
//                orientation = LinearLayout.HORIZONTAL
//                for (j in 1..4) addView(catViews[(it) * 4 + (j - 1)])
//            }
//        }
//
//        for (row in rows) layout.addView(row)
        setContentView(game.generateGame())
    }
}