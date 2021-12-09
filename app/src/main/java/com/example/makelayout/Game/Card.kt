package com.example.makelayout.Game

import android.widget.ImageView

class Card(val cardView: ImageView, var linkCard: Card? = null) {
    /**
     * Card status
     */
    var isOpen: Boolean = false


    /**
     * Generate a pair for the card
     * @return The object of the second card
     */
    fun generatePair(): Card {
        if (linkCard == null) {
            val secondCard: Card = this.clone()

            secondCard.linkCard = this
            this.linkCard = secondCard

            return secondCard
        } else
            throw  Exception("The card has a pair")
    }

    private fun clone(): Card {
        return Card(this.cardView, this.linkCard)
    }
}