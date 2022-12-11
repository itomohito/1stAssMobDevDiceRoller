package com.example.diceroller2

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        rollDice()
    }

    private fun rollDice() {
        //creating a newdice with 6 sides
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // finding the image in the layout
        val diceImage: ImageView = findViewById(R.id.imageView2)

        // setting images according to numbers
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // updating the image with resource id
        diceImage.setImageResource(drawableResource)

        //update the content decription
        diceImage.contentDescription = diceRoll.toString()
    }

    class Dice(private val numSides: Int) {

        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}