package com.example.makelayout.Game

import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.makelayout.R

class Game(private val gridSize: Int = 4, private val context: Context) {
    val layout = LinearLayout(context)
    val params = LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.WRAP_CONTENT,
        LinearLayout.LayoutParams.MATCH_PARENT
    )


    /**
     * Array of cards
     */
    private val cardViews = ArrayList<Card>(gridSize * 4)

    private val rows = ArrayList<LinearLayout>(gridSize)

    private val images = arrayOf(
        R.drawable.one_card,
        R.drawable.two_card,
        R.drawable.three_card,
        R.drawable.four_card,
        R.drawable.five_card,
        R.drawable.six_card,
        R.drawable.seven_card,
        R.drawable.eight_card
    )

    /**
     * Generates linked pairs of cards in random order
     */
    private fun generateCards() {
        for (n in 1..gridSize * 2) {
            val card = Card(ImageView(context).apply {
                setImageResource(images[n - 1])
                layoutParams = params
                setOnClickListener(colorListener)
            })

            val card2 = Card(ImageView(context).apply {
                setImageResource(images[n - 1])
                layoutParams = params
                setOnClickListener(colorListener)
            })
            card.linkCard = card2
            card2.linkCard = card
            cardViews.apply {
                add(card)
                add(card2)
            }
        }

        cardViews.shuffle()
    }

    fun generateGame(): LinearLayout {
        params.weight = 1.toFloat()

        layout.layoutParams = params
        layout.orientation = LinearLayout.VERTICAL


        generateCards()

        for (i in 1..gridSize) {
            rows.add(
                LinearLayout(context).apply {
                    orientation = LinearLayout.HORIZONTAL
                    layoutParams = params
                    for (j in 1..gridSize) {
                        val tmp = (i - 1) * gridSize + (j - 1)
                        addView(cardViews[tmp].cardView)
                    }
                }
            )
            layout.addView(rows[i - 1])
        }

        return layout
    }

    val colorListener = View.OnClickListener {
        it.setBackgroundColor(Color.YELLOW)
    }
}