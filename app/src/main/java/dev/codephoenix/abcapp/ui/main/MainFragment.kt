package dev.codephoenix.abcapp.ui.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.codephoenix.abcapp.MainActivity
import dev.codephoenix.abcapp.R
import dev.codephoenix.abcapp.data.ColorObj
import dev.codephoenix.abcapp.data.LearningElements
import dev.codephoenix.abcapp.ui.main.learningElements.LearningListFragment
import kotlinx.android.synthetic.main.main_fragment.*

class  MainFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
//        val mainActivity : MainActivity = activity as MainActivity
//        //removes up navigation arrow
//        mainActivity.supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.main_fragment, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Abc Card Clicked
        abc_card!!.setOnClickListener {
            val mainActivity : MainActivity = activity as MainActivity
            val abcList: ArrayList<String> = ArrayList()
            //add alphabet to abc list
            LearningElements().addAlphabet(abcList)

            mainActivity.supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, LearningListFragment.newInstance(abcList))
                .addToBackStack(null)
                .commit()
        }
        //Number Card Clicked
        number_card!!.setOnClickListener {
            val mainActivity: MainActivity = activity as MainActivity
            val numberList: ArrayList<String> = ArrayList()
            //add numbers numberList
            LearningElements().addNumbers(numberList)

            mainActivity.supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, LearningListFragment.newInstance(numberList))
                .addToBackStack(null)
                .commit()
        }

        //Shapes Card Clicked
        shapes_card!!.setOnClickListener {

        }

        //Colors Card
        colors_card!!.setOnClickListener {
            val mainActivity: MainActivity = activity as MainActivity
            val colorsList: ArrayList<ColorObj> = ArrayList()
            //add numbers numberList
            LearningElements().addColors(colorsList, context)

            mainActivity.supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, LearningListFragment.newColorInstance(colorsList))
                .addToBackStack(null)
                .commit()
        }
    }

    //Todo: Add Shapes & Colors
    companion object {
        fun newInstance() = MainFragment()
    }

}
