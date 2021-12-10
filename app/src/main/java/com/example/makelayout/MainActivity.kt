package com.example.makelayout

import android.os.Bundle
import com.example.makelayout.Game.Game
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val game = Game(context = this)

        setContentView(game.generateGame())
    }
}