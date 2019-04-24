package dev.codephoenix.abcapp.data

import android.graphics.Color

class LearningElements {

    fun addAlphabet(abcList: ArrayList<String>) {

        var letter = 'A'

        while (letter <= 'Z') {
            abcList.add(letter.toString())
            ++letter
        }
    }

    fun addNumbers(numbers: ArrayList<String>) {

        var number = 1

        while (number <= 100) {
            numbers.add(number.toString())
            ++number
        }
    }

    fun addColors(colors: ArrayList<ColorObj>) {

        val red = ColorObj("red", Color.RED)
        val blue = ColorObj("blue", Color.BLUE)
        val green = ColorObj("green", Color.GREEN)
        val yellow = ColorObj("yellow", Color.YELLOW)

        colors.add(red)
        colors.add(blue)
        colors.add(green)
        colors.add(yellow)

    }
}