package com.example.games

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    var player = 1
    var p1 = ArrayList<Int>()
    var p2 = ArrayList<Int>()
    var win = 0
    var p1Score = 0
    var p2Score = 0
    var available = listOf<Int>(1,2,3,4,5,6,7,8,9)
    var availabeSpaces = available.toMutableList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun gameOn(buttonCode: Int, selectedButton: Button){
        if(player == 1){
            player1Plays(selectedButton, buttonCode)
        }else if(player == 2){
            player2Plays(selectedButton, buttonCode)
        }
        selectedButton.isEnabled = false
    }

    fun gameOnAI(buttonCode: Int, selectedButton: Button){
        player1Plays(selectedButton, buttonCode)
        var randNum = available.random()
        if(win == 0){
            var AIButton = findViewById<Button>(R.id.button)
            when(randNum){
                1 -> AIButton = findViewById(R.id.button)
                2 -> AIButton = findViewById(R.id.button2)
                3 -> AIButton = findViewById(R.id.button3)
                4 -> AIButton = findViewById(R.id.button4)
                5 -> AIButton = findViewById(R.id.button5)
                6 -> AIButton = findViewById(R.id.button6)
                7 -> AIButton = findViewById(R.id.button7)
                8 -> AIButton = findViewById(R.id.button8)
                9 -> AIButton = findViewById(R.id.button9)
            }
            player2Plays(AIButton, randNum)
        }
    }


    fun player1Plays(selectedButton: Button, buttonCode: Int){
        selectedButton.text = "X"
        selectedButton.setBackgroundResource(R.color.blue)
        p1.add(buttonCode)
        availabeSpaces.remove(buttonCode)
        available = availabeSpaces
        player = 2
    }
    fun player2Plays(selectedButton: Button, buttonCode: Int){
        selectedButton.text = "O"
        selectedButton.setBackgroundResource(R.color.green)
        p2.add(buttonCode)
        availabeSpaces.remove(buttonCode)
        available = availabeSpaces
        player = 1
    }

    fun select(view: View) {
        val selectedButton = view as Button
        var buttonCode = 0
        when(selectedButton.id){
            R.id.button -> buttonCode = 1
            R.id.button2 -> buttonCode = 2
            R.id.button3 -> buttonCode = 3
            R.id.button4 -> buttonCode = 4
            R.id.button5 -> buttonCode = 5
            R.id.button6 -> buttonCode = 6
            R.id.button7 -> buttonCode = 7
            R.id.button8 -> buttonCode = 8
            R.id.button9 -> buttonCode = 9
        }
        selectedButton.isEnabled = false
        gameOnAI(buttonCode, selectedButton)
        andTheWinnerIs()
    }

    fun andTheWinnerIs()
    {
        if(p1.contains(1) && p1.contains(2) && p1.contains(3)) win = 1

        if(p2.contains(1) && p2.contains(2) && p2.contains(3)) win = 2


        if(p1.contains(4) && p1.contains(5) && p1.contains(6)) win = 1

        if(p2.contains(4) && p2.contains(5) && p2.contains(6)) win = 2


        if(p1.contains(7) && p1.contains(8) && p1.contains(9)) win = 1

        if(p2.contains(7) && p2.contains(8) && p2.contains(9)) win = 2


        if(p1.contains(1) && p1.contains(4) && p1.contains(7)) win = 1

        if(p2.contains(1) && p2.contains(4) && p2.contains(7)) win = 2


        if(p1.contains(2) && p1.contains(5) && p1.contains(8)) win = 1

        if(p2.contains(2) && p2.contains(5) && p2.contains(8)) win = 2


        if(p1.contains(3) && p1.contains(6) && p1.contains(9)) win = 1

        if(p2.contains(3) && p2.contains(6) && p2.contains(9)) win = 2


        if(p1.contains(1) && p1.contains(5) && p1.contains(9)) win = 1

        if(p2.contains(1) && p2.contains(5) && p2.contains(9)) win = 2


        if(p1.contains(3) && p1.contains(5) && p1.contains(7)) win = 1

        if(p2.contains(3) && p2.contains(5) && p2.contains(7)) win = 2

        if (win != 0)
        {
            if(win == 1) p1Score += 1
            if(win == 2) p2Score += 1
            Toast.makeText(this, "And the winner is player $win. Score is p1: $p1Score" +
                    "p2: $p2Score", Toast.LENGTH_LONG).show()
            var textV = findViewById<TextView>(R.id.p1Score)
            var textV2 = findViewById<TextView>(R.id.p2Score)
            textV.setText("P1: $p1Score")
            textV2.setText("P2: $p2Score")
            var button = findViewById<Button>(R.id.button)
            var button2 = findViewById<Button>(R.id.button2)
            var button3 = findViewById<Button>(R.id.button3)
            var button4 = findViewById<Button>(R.id.button4)
            var button5 = findViewById<Button>(R.id.button5)
            var button6 = findViewById<Button>(R.id.button6)
            var button7 = findViewById<Button>(R.id.button7)
            var button8 = findViewById<Button>(R.id.button8)
            var button9 = findViewById<Button>(R.id.button9)
            button.isEnabled = false
            button2.isEnabled = false
            button3.isEnabled = false
            button4.isEnabled = false
            button5.isEnabled = false
            button6.isEnabled = false
            button7.isEnabled = false
            button8.isEnabled = false
            button9.isEnabled = false
        }
    }

    fun reset(view: View){
        var button = findViewById<Button>(R.id.button)
        var button2 = findViewById<Button>(R.id.button2)
        var button3 = findViewById<Button>(R.id.button3)
        var button4 = findViewById<Button>(R.id.button4)
        var button5 = findViewById<Button>(R.id.button5)
        var button6 = findViewById<Button>(R.id.button6)
        var button7 = findViewById<Button>(R.id.button7)
        var button8 = findViewById<Button>(R.id.button8)
        var button9 = findViewById<Button>(R.id.button9)
        blankButton(button)
        blankButton(button2)
        blankButton(button3)
        blankButton(button4)
        blankButton(button5)
        blankButton(button6)
        blankButton(button7)
        blankButton(button8)
        blankButton(button9)
        button.isEnabled = true
        button2.isEnabled = true
        button3.isEnabled = true
        button4.isEnabled = true
        button5.isEnabled = true
        button6.isEnabled = true
        button7.isEnabled = true
        button8.isEnabled = true
        button9.isEnabled = true
        available = listOf<Int>(1,2,3,4,5,6,7,8,9)
        availabeSpaces = available.toMutableList()
        p1.clear()
        p2.clear()
        win = 0
    }

    fun blankButton(button: Button){
        button.text = ""
        button.setBackgroundResource(R.color.white)
    }

}
