package com.example.dice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    //Setting variables of the game

    val player1: Int = 0
    val player2: Int = 0
    val win = ""
    var count = 0
    var playertotal = 0
    var computertotal = 0
    var winscore = 101
    var random_number: Int = 0
    var random_number2: Int = 0
    var random_number3: Int = 0
    var random_number4: Int = 0
    var random_number5: Int = 0
    var random_number6: Int = 0
    var random_number7: Int = 0
    var random_number8: Int = 0
    var random_number9: Int = 0
    var random_number10: Int = 0

// Create Image variables
    lateinit var diseimage: ImageView
    lateinit var diseimage2: ImageView
    lateinit var diseimage3: ImageView
    lateinit var diseimage4: ImageView
    lateinit var diseimage5: ImageView
    lateinit var diseimage6: ImageView
    lateinit var diseimage7: ImageView
    lateinit var diseimage8: ImageView
    lateinit var diseimage9: ImageView
    lateinit var diseimage10: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loading_menu)

        val aboutButton: Button = findViewById(R.id.button2)
        aboutButton.setOnClickListener {
            setContentView(R.layout.about_page)

            val backButtonabout: Button = findViewById(R.id.about_back)
            backButtonabout.setOnClickListener{
                setContentView(R.layout.loading_menu)
            }
        }


        val newButton: Button = findViewById(R.id.newgame)
        newButton.setOnClickListener {
            setContentView(R.layout.activity_main)


// create a to toll the dice an call the if condition when it clicked
            val rollButton: Button = findViewById(R.id.roll)
            rollButton.setOnClickListener {
                //By using if look set a count and limit the rounds to 3
                if (count < 3) {

                    count++
// Calling Dice Rolling Functions
                    val Result1 = rollDice()
                    val Result2 = rollDice2()
                    val Result3 = rollDice3()
                    val Result4 = rollDice4()
                    val Result5 = rollDice5()
                    val Result6 = rollDice6()
                    val Result7 = rollDice7()
                    val Result8 = rollDice8()
                    val Result9 = rollDice9()
                    val Result10 = rollDice10()


                    // Calling total calculation functions and assign them to text fields
                    val myTextView = findViewById<TextView>(R.id.textView3)
                    val result = Total1(Result1, Result3, Result5, Result7, Result9)
                    myTextView.text = result.toString()

                    val myTextView2 = findViewById<TextView>(R.id.textView4)
                    val result2 = Total2(Result2, Result4, Result6, Result8, Result10)
                    myTextView2.text = result2.toString()

                    val myTextView3 = findViewById<TextView>(R.id.textView6)
                    myTextView3.text = count.toString()

                    playertotal+=result
                    computertotal+=result2

                   //Giving user the option to update score in 1st and 2nd chances and in 3rd automaticly update the score
                    if (count == 1|| count ==2){
                       val scoreButton:Button = findViewById(R.id.button4)
                        scoreButton.setOnClickListener {
                            val myTextView4 = findViewById<TextView>(R.id.playertotal)
                            myTextView4.text = playertotal.toString()

                            val myTextView5 = findViewById<TextView>(R.id.textView11)
                            myTextView5.text = computertotal.toString()

                        }
                    } else{
                        val myTextView4 = findViewById<TextView>(R.id.playertotal)
                        myTextView4.text = playertotal.toString()

                        val myTextView5 = findViewById<TextView>(R.id.textView11)
                        myTextView5.text = computertotal.toString()

                    }




//Displaying the win states
                } else {
                    rollButton.isEnabled = false
                    if(playertotal>=winscore&&playertotal>computertotal){
                        val win = "You Win"
                        val myTextView6 = findViewById<TextView>(R.id.textView12)
                        myTextView6.text = win.toString()
                    } else if (playertotal==computertotal){
                        val win = "Draw"
                        val myTextView6 = findViewById<TextView>(R.id.textView12)
                        myTextView6.text = win.toString()
                    } else {
                        val win = "You Lose"
                        val myTextView6 = findViewById<TextView>(R.id.textView12)
                        myTextView6.text = win.toString()
                    }
                }
// Create a button to resert game values and resert all values to 0
                val restartButton: Button = findViewById(R.id.restart)
                restartButton.setOnClickListener {
                    count = 0
                    playertotal=0
                    computertotal=0
                    val win = ""
                    val myTextView6 = findViewById<TextView>(R.id.textView12)
                    myTextView6.text = win.toString()
                    rollButton.isEnabled = true
                }

            }
            //Assigning dice images to imageViews
            diseimage = findViewById(R.id.imageView)
            diseimage2 = findViewById(R.id.imageView2)
            diseimage3 = findViewById(R.id.imageView3)
            diseimage4 = findViewById(R.id.imageView4)
            diseimage5 = findViewById(R.id.imageView5)
            diseimage6 = findViewById(R.id.imageView6)
            diseimage7 = findViewById(R.id.imageView7)
            diseimage8 = findViewById(R.id.imageView8)
            diseimage9 = findViewById(R.id.imageView9)
            diseimage10 = findViewById(R.id.imageView10)


        }

    }
    /** Create a random number between 1 and 6 and assign image accoding to the number
     *@return random_number
     */
    private fun rollDice(): Int {
        random_number = (1..6).random()
        val drawableResource = when (random_number) {
            1 -> R.drawable.one
            2 -> R.drawable.two
            3 -> R.drawable.three
            4 -> R.drawable.four
            5 -> R.drawable.five
            else -> R.drawable.six
        }
        diseimage.setImageResource(drawableResource)
        return random_number

    }
    /** Create a random number between 1 and 6 and assign image accoding to the number
     *@return random_number2
     */
    private fun rollDice2(): Int {
        random_number2 = (1..6).random()
        val drawableResource = when (random_number2) {
            1 -> R.drawable.one
            2 -> R.drawable.two
            3 -> R.drawable.three
            4 -> R.drawable.four
            5 -> R.drawable.five
            else -> R.drawable.six
        }
        diseimage2.setImageResource(drawableResource)
        return random_number2

    }
    /** Create a random number between 1 and 6 and assign image accoding to the number
     *@return random_number3
     */
    private fun rollDice3(): Int {
        random_number3 = (1..6).random()
        val drawableResource = when (random_number3) {
            1 -> R.drawable.one
            2 -> R.drawable.two
            3 -> R.drawable.three
            4 -> R.drawable.four
            5 -> R.drawable.five
            else -> R.drawable.six
        }
        diseimage3.setImageResource(drawableResource)
        return random_number3

    }
    /** Create a random number between 1 and 6 and assign image accoding to the number
     *@return random_number4
     */
    private fun rollDice4(): Int {
        random_number4 = (1..6).random()
        val drawableResource = when (random_number4) {
            1 -> R.drawable.one
            2 -> R.drawable.two
            3 -> R.drawable.three
            4 -> R.drawable.four
            5 -> R.drawable.five
            else -> R.drawable.six
        }
        diseimage4.setImageResource(drawableResource)
        return random_number4

    }
    /** Create a random number between 1 and 6 and assign image accoding to the number
     *@return random_number5
     */
    private fun rollDice5(): Int {
        random_number5 = (1..6).random()
        val drawableResource = when (random_number5) {
            1 -> R.drawable.one
            2 -> R.drawable.two
            3 -> R.drawable.three
            4 -> R.drawable.four
            5 -> R.drawable.five
            else -> R.drawable.six
        }
        diseimage5.setImageResource(drawableResource)
        return random_number5

    }
    /** Create a random number between 1 and 6 and assign image accoding to the number
     *@return random_number6
     */
    private fun rollDice6(): Int {
        random_number6 = (1..6).random()
        val drawableResource = when (random_number6) {
            1 -> R.drawable.one
            2 -> R.drawable.two
            3 -> R.drawable.three
            4 -> R.drawable.four
            5 -> R.drawable.five
            else -> R.drawable.six
        }
        diseimage6.setImageResource(drawableResource)
        return random_number6

    }
    /** Create a random number between 1 and 6 and assign image accoding to the number
     *@return random_number7
     */
    private fun rollDice7(): Int {
        random_number7 = (1..6).random()
        val drawableResource = when (random_number7) {
            1 -> R.drawable.one
            2 -> R.drawable.two
            3 -> R.drawable.three
            4 -> R.drawable.four
            5 -> R.drawable.five
            else -> R.drawable.six
        }
        diseimage7.setImageResource(drawableResource)
        return random_number7

    }
    /** Create a random number between 1 and 6 and assign image accoding to the number
     *@return random_number8
     */
    private fun rollDice8(): Int {
        random_number8 = (1..6).random()
        val drawableResource = when (random_number8) {
            1 -> R.drawable.one
            2 -> R.drawable.two
            3 -> R.drawable.three
            4 -> R.drawable.four
            5 -> R.drawable.five
            else -> R.drawable.six
        }
        diseimage8.setImageResource(drawableResource)
        return random_number8

    }
    /** Create a random number between 1 and 6 and assign image accoding to the number
     *@return random_number9
     */
    private fun rollDice9(): Int {
        random_number9 = (1..6).random()
        val drawableResource = when (random_number9) {
            1 -> R.drawable.one
            2 -> R.drawable.two
            3 -> R.drawable.three
            4 -> R.drawable.four
            5 -> R.drawable.five
            else -> R.drawable.six
        }
        diseimage9.setImageResource(drawableResource)
        return random_number9

    }
    /** Create a random number between 1 and 6 and assign image accoding to the number
     *@return random_number10
     */
    private fun rollDice10(): Int {
        random_number10 = (1..6).random()
        val drawableResource = when (random_number10) {
            1 -> R.drawable.one
            2 -> R.drawable.two
            3 -> R.drawable.three
            4 -> R.drawable.four
            5 -> R.drawable.five
            else -> R.drawable.six
        }
        diseimage10.setImageResource(drawableResource)
        return random_number10


    }
    /** Get a user input for winScore
     *@return winscore
     */
    //Haven't used in the code
    private fun SetWinScore(): Int {
        println("What is the Game Score")
       val winscoreInput = readLine()
        winscore = winscoreInput?.toIntOrNull()?:0

        return winscore

    }
    /** Calculate the total score of 5 dices of the Player
     *@return Total1
     */
    private fun Total1(Result1: Int, Result3: Int, Result5: Int, Result7: Int, Result9: Int): Int {
        val Total1 = Result1 + Result3 + Result5 + Result7 + Result9

        return Total1

    }
    /** Calculate the total score of 5 dices of the Computer
     *@return Total2
     */
    private fun Total2(Result2: Int, Result4: Int, Result6: Int, Result8: Int, Result10: Int): Int {
        val Total2 = Result2 + Result4 + Result6 + Result8 + Result10

        return Total2


    }
}


