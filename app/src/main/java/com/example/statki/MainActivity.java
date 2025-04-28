package com.example.statkigra


import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.GridLayout
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var gridLayout: GridLayout
    private val buttonList = mutableListOf<Button>()
    private val shipPositions = mutableSetOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gridLayout = findViewById(R.id.gridLayout)

        createButtons()
        assignShips()
    }

    private fun createButtons() {
        for (i in 0 until 100) {
            val button = Button(this)
            button.layoutParams = GridLayout.LayoutParams().apply {
                width = 0
                height = 0
                rowSpec = GridLayout.spec(i / 10, 1f)
                columnSpec = GridLayout.spec(i % 10, 1f)
                setMargins(2, 2, 2, 2)
            }

            button.setBackgroundColor(Color.LTGRAY)

            button.setOnClickListener {
                if (shipPositions.contains(i)) {
                    button.setBackgroundColor(Color.GREEN)
                } else {
                    button.setBackgroundColor(Color.RED)
                }
                button.isEnabled = false
            }

            buttonList.add(button)
            gridLayout.addView(button)
        }
    }

    private fun assignShips() {
        while (shipPositions.size < 10) {
            val pos = Random.nextInt(0, 100)
            shipPositions.add(pos)
        }
    }
}



