package dev.codephoenix.abcapp.ui.main.learningElements

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import dev.codephoenix.abcapp.MainActivity
import dev.codephoenix.abcapp.R
import dev.codephoenix.abcapp.data.ColorObj
import kotlinx.android.synthetic.main.abc_fragment.*

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class LearningListFragment : Fragment() {

    var learningElements: ArrayList<String>? = ArrayList()
    var colorElements: ArrayList<ColorObj>? = ArrayList()

    companion object {
        val CURRENT_LIST = "currentList"
        val COLOR_LIST = "colorList"

        fun newInstance(currentList: ArrayList<String>?): LearningListFragment {
            val fragment = LearningListFragment()
            val args = Bundle()
            args.putStringArrayList(CURRENT_LIST, currentList)
            fragment.arguments = args
            return fragment
        }

        fun newColorInstance(colorList: ArrayList<ColorObj>?): LearningListFragment {
            val fragment = LearningListFragment()
            val args = Bundle()
            args.putParcelableArrayList(COLOR_LIST, colorList)
            fragment.arguments = args
            return fragment
        }

        //Todo: Create custom function adding list of images for shapes a
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.abc_fragment, container, false)
        // Retrieve Bungles for data passed in from @param MainFragment
        val stringArguments = arguments?.getStringArrayList(CURRENT_LIST)
        val colorArguments: ArrayList<ColorObj>? = arguments?.getParcelableArrayList(COLOR_LIST)

        learningElements = stringArguments
        colorElements = colorArguments

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        abc_recyclerview?.layoutManager = GridLayoutManager(context, 4)
        if (learningElements == null) {
            //set recyclerview for colors
            abc_recyclerview?.adapter = LearningElementsRecyclerViewAdpater(context,
                activity as MainActivity, learningElements, colorElements)
        } else {
            abc_recyclerview?.adapter = LearningElementsRecyclerViewAdpater(
                context, activity as MainActivity, learningElements)
        }
    }
}
