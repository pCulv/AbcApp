package dev.codephoenix.abcapp.data

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

    fun addColors(colors: ArrayList<String>, isColor: Boolean) {

//        val red =
        val blue = R.color.blue
        val green = R.color.green
        val yellow = R.color.yellow

//        colors.add(red.toString())
        colors.add(blue.toString())
        colors.add(green.toString())
        colors.add(yellow.toString())

    }
}