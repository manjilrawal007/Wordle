package com.example.wordle

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wordle_final.FourLetterWordList


lateinit var submitBtn : Button
lateinit var myText : TextView
lateinit var myGuess : EditText

lateinit var myGuessWord : String

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var counting = 1
        val guessing = findViewById<EditText>(R.id.guess_text)
        val btn = findViewById<Button>(R.id.button_main)
        val firstName = findViewById<TextView>(R.id.Guess1_val)
        val secondName = findViewById<TextView>(R.id.Guess1Check_val)
        val thirdText = findViewById<TextView>(R.id.Guess2_val)
        val fourthText = findViewById<TextView>(R.id.Guess2Check_val)
        val fifthText = findViewById<TextView>(R.id.Guess3_val)
        val sixthText = findViewById<TextView>(R.id.Guess3Check_val)
        val rightSide = findViewById<TextView>(R.id.CorrectWord)

        val wordForGuessing = FourLetterWordList.FourLetterWordList.getRandomFourLetterWord()
        fun checkGuess(guess: String) : String {
            var resulting = ""
            for (i in 0..3) {
                if (guess[i] == wordForGuessing[i]) {
                    resulting += "O"
                }
                else if (guess[i] in wordForGuessing) {
                    resulting += "+"
                }
                else {
                    resulting += "X"
                }
            }
            return resulting
        }

        btn.setOnClickListener {
            var rights = ""
            var firstWord = ""
            var secondWord = ""
            var thirdWord = ""
            if (counting == 1) {

                firstWord = guessing.text.toString().uppercase()
                firstName.text = firstWord
                rights = checkGuess (firstWord)
                secondName.text = rights
                counting = counting + 1
//
//              text1.apply { text=word1}
            } else if (counting == 2) {

                secondWord = guessing.text.toString().uppercase()
                thirdText.text = secondWord
                rights = checkGuess(secondWord)
                fourthText.text = rights
                counting = counting + 1
            } else if (counting == 3) {

                thirdWord = guessing.text.toString().uppercase()
                fifthText.text = thirdWord
                rights = checkGuess(thirdWord)
                sixthText.text = rights
                counting = counting + 1
                rightSide.text = wordForGuessing
                Toast.makeText(applicationContext,"Out of Tries !",Toast.LENGTH_LONG).show()

            }


        }
    }
}