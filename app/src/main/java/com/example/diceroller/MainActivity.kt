package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the Button in the layout
        val rollButton: Button = findViewById(R.id.button)

        //// Set a click listener on the button to roll the dice when the user taps the button
        rollButton.setOnClickListener {
            Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()

            val resultTextView: TextView = findViewById(R.id.textView)
            resultTextView.text = "6"

            rollDice()
        }

        // Do a dice roll when the app starts
        rollDice()
    }

    // Roll the dice and update the screen with the result.
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceRoll2 = dice.roll()

        // Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView2)

        diceImage.contentDescription = "Not yet roll"
        diceImage2.contentDescription = "Not yet roll"

        // Update the screen with the dice number
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = (diceRoll + diceRoll2).toString()

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val drawableResource2 = when (diceRoll2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)
        diceImage2.setImageResource(drawableResource2)

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
        diceImage2.contentDescription = diceRoll.toString()
    }
}

// Dice class
class Dice(private val numSides: Int) {

    // Do a random dice roll and return the result.
    fun roll(): Int {
        return (1..numSides).random()
    }
}

