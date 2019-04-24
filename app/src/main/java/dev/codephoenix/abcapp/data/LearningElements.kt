package dev.codephoenix.abcapp.data

import android.content.Context
import android.support.v4.content.ContextCompat
import dev.codephoenix.abcapp.R

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

    fun addColors(colors: ArrayList<ColorObj>, context: Context?) {

        val red = ColorObj("Red", ContextCompat.getColor(context!!, R.color.red))
        val blue = ColorObj("Blue", ContextCompat.getColor(context!!, R.color.blue))
        val green = ColorObj("Green", ContextCompat.getColor(context!!, R.color.green))
        val yellow = ColorObj("Yellow", ContextCompat.getColor(context!!, R.color.yellow))
        val orange = ColorObj("Orange", ContextCompat.getColor(context!!, R.color.orange))
        //Todo: Add additional colors

        colors.add(red)
        colors.add(blue)
        colors.add(green)
        colors.add(yellow)
        colors.add(orange)

    }
}