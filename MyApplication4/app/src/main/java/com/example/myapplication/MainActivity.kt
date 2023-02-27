package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var gridLayout: GridLayout
    private lateinit var cells: Array<Array<TextView>>
    private var currentPlayer = "X"
    private var gameOver = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gridLayout = findViewById(R.id.gridLayout)

        cells = Array(3) { row ->
            Array(3) { column ->
                val cell = gridLayout.getChildAt(row * 3 + column) as TextView
                cell.setOnClickListener { onCellClick(cell, row, column) }
                cell
            }
        }
    }

    private fun onCellClick(cell: TextView, row: Int, column: Int) {
        if (!gameOver && cell.text.isEmpty()) {
            cell.text = currentPlayer
            checkWin(row, column)
            switchPlayer()
        }
    }

    private fun checkWin(row: Int, column: Int) {
        // Check row
        if (cells[row][0].text == currentPlayer &&
            cells[row][1].text == currentPlayer &&
            cells[row][2].text == currentPlayer) {
            gameOver = true
            showWinMessage()
            return
        }

        // Check column
        if (cells[0][column].text == currentPlayer &&
            cells[1][column].text == currentPlayer &&
            cells[2][column].text == currentPlayer) {
            gameOver = true
            showWinMessage()
            return
        }

        // Check diagonal (if applicable)
        if (row == column) {
            if (cells[0][0].text == currentPlayer &&
                cells[1][1].text == currentPlayer &&
                cells[2][2].text == currentPlayer) {
                gameOver = true
                showWinMessage()
                return
            }
        }
        if (row + column == 2) {
            if (cells[0][2].text == currentPlayer &&
                cells[1][1].text == currentPlayer &&
                cells[2][0].text == currentPlayer) {
                gameOver = true
                showWinMessage()
                return
            }
        }

        // Check tie
        if (isBoardFull()) {
            gameOver = true
            showTieMessage()
            return
        }
    }

    private fun switchPlayer() {
        currentPlayer = if (currentPlayer == "X") "O" else "X"
    }

    private fun isBoardFull(): Boolean {
        for (row in cells) {
            for (cell in row) {
                if (cell.text.isEmpty()) {
                    return false
                }
            }
        }
        return true
    }

    private fun showWinMessage() {
        Toast.makeText(this, "Player $currentPlayer wins!", Toast.LENGTH_SHORT).show()
    }

    private fun showTieMessage() {
        Toast.makeText(this, "It's a tie!", Toast.LENGTH_SHORT).show()
    }

}