package com.example.makelayout.Game

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.makelayout.R

class Game(private val gridSize: Int, private val context: Context) {
    val layout = LinearLayout(context)
    val params = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT)


    /**
     * Array of cards
     */
    private val cardViews = ArrayList<Card>(gridSize * 4)

    private val rows = ArrayList<LinearLayout>(gridSize)

    private fun generateCards() {
        for (n in 1..8) {

            val card = Card(ImageView(context).apply {
                setImageResource(R.drawable.squarecat)
                layoutParams = params
                setOnClickListener(colorListener)
            })

            val card2 = Card(ImageView(context).apply {
                setImageResource(R.drawable.squarecat)
                layoutParams = params
                setOnClickListener(colorListener)
            })
            card.linkCard = card2
            card2.linkCard = card
            cardViews.apply {
                add(card)
                add(card2)
            }

//            cardViews.add(Pair(card, card.generatePair()))
        }
    }

    fun generateGame(): LinearLayout {
        // Генерирует два объекта карточек и связываем их

        layout.orientation = LinearLayout.VERTICAL

        params.weight = 1.toFloat()

        generateCards()

//        Log.d("card", "card-first: " + cardViews[0].toString())
//        Log.d("card", "card-first-link: " + cardViews[0].linkCard.toString())
//        Log.d("card", "card-second: " + cardViews[1].toString())
//        Log.d("card", "card-second-link: " + cardViews[1].linkCard.toString())
//        Log.d("card", "carViews size: " + cardViews.size.toString())


        for (i in 1..gridSize) {
            rows.add(
                LinearLayout(context).apply {
                    orientation = LinearLayout.HORIZONTAL
                    for (j in 1..gridSize)  {
                        val tmp = (i - 1) * gridSize + (j - 1)
                        Log.d("card", cardViews[tmp].cardView.toString())
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