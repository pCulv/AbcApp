package dev.codephoenix.abcapp.di

import android.content.Context
import dev.codephoenix.abcapp.data.ColorObj

interface LearningElementsRepository {

    fun addAlphabet(abcList: ArrayList<String>)
    fun addNumbers(numbers: ArrayList<String>)
    fun addColors(colors: ArrayList<ColorObj>, context: Context)
}