package com.android.academy.mycalc

interface CalcService {
    val display: String
    fun digit(d: Char): Unit
    fun comma(): Unit
    fun execute(operation: Char)
    fun clear(): Unit
    fun clearError(): Unit
    fun changeSign(): Unit
}

class CalcServiceImpl() : CalcService {

    companion object {
        const val TAG = "CalcServiceImpl"
    }

    private var accumulator: Double = 0.0
    private var internalDisplay: String = "0,"
    private var mustClearDisplay: Boolean = true
    private var nextOperation: Char = '='

    private val value
        get() = if (display.isEmpty()) 0.0 else display.replace(',', '.').toDouble()

    private fun checkIfClearDisplay() {
        if (mustClearDisplay) {
            mustClearDisplay = false
            internalDisplay = ""
        }
    }

    override val display: String
        get() = internalDisplay

    override fun digit(d: Char) {
        checkIfClearDisplay()
        if (d == '0') {
            if (internalDisplay.any()) internalDisplay += '0' else {
                internalDisplay = "0"; mustClearDisplay = true;
            }
        } else internalDisplay += d
    }

    override fun comma() {
        checkIfClearDisplay()
        if (internalDisplay.isEmpty()) internalDisplay = "0,"
        if (!internalDisplay.contains(",")) internalDisplay += ","
    }

    override fun execute(operation: Char) {
        when (nextOperation) {
            '+' -> accumulator += value
            '-' -> accumulator -= value
            '*' -> accumulator *= value
            '/' -> accumulator /= value
            else -> accumulator = value
        }
        mustClearDisplay = true
        nextOperation = operation
        internalDisplay = accumulator.toString()
    }

    override fun clear() {
        accumulator = 0.0
        internalDisplay = "0,"
        mustClearDisplay = true
    }

    override fun clearError() {
        internalDisplay = "0,"
        mustClearDisplay = true
    }

    override fun changeSign() {
        internalDisplay = (-value).toString()
    }

}