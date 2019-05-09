package dev.codephoenix.abcapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.codephoenix.abcapp.MainActivity
import dev.codephoenix.abcapp.R
import dev.codephoenix.abcapp.data.ColorObj
import dev.codephoenix.abcapp.data.LearningElements
import dev.codephoenix.abcapp.ui.main.learningElements.LearningListFragment
import kotlinx.android.synthetic.main.main_fragment.*
import org.koin.android.ext.android.inject

class  MainFragment : Fragment() {

    private val learningElements: LearningElements by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true

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
            learningElements.addAlphabet(abcList)
            //display abc list
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
            learningElements.addNumbers(numberList)
            //display number list
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
            learningElements.addColors(colorsList, context!!)
            //display color list
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
