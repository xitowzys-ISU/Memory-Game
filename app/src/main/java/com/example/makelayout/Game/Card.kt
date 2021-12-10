package com.example.makelayout.Game

import android.widget.ImageView
import com.example.makelayout.R

class Card(
    val cardView: ImageView,
    var linkCard: Card? = null,
    val imageCard: Int,
    val shirtCard: Int = R.drawable.shirt_card
) {

    init {
        cardView.setImageResource(shirtCard)
    }

    /**
     * Card status
     */
    private var isOpen: Boolean = false

    /**
     * Flips the card
     */
    fun flipCard() {
        isOpen = isOpen.not()

        if (isOpen) cardView.setImageResource(imageCard) else cardView.setImageResource(shirtCard)
    }

//    /**
//     * Generate a pair for the card
//     * @return The object of the second card
//     */
//    fun generatePair(): Card {
//        if (linkCard == null) {
//            val secondCard: Card = this.clone()
//
//            secondCard.linkCard = this
//            this.linkCard = secondCard
//
//            return secondCard
//        } else
//            throw  Exception("The card has a pair")
//    }
//
//
//
//    private fun clone(): Card {
//        return Card(this.cardView, this.linkCard)
//    }

}