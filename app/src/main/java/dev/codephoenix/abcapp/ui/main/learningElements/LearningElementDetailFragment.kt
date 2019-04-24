package dev.codephoenix.abcapp.ui.main.learningElements

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.codephoenix.abcapp.R
import dev.codephoenix.abcapp.data.ColorObj
import kotlinx.android.synthetic.main.letter_detail_frag.*

class LearningElementDetailFragment : Fragment() {

    companion object {

        val CURRENT_LIST = "currentList"
        val COLOR_LIST = "colorList"
        val CURRENT_ITEM = "itemPosition"
        val CURRENT_COLOR = "currentColor"

        fun newInstance(currentList: ArrayList<String>?, currentItem: Int): LearningElementDetailFragment {
            val fragment = LearningElementDetailFragment()
            val args = Bundle()
            args.putStringArrayList(CURRENT_LIST, currentList)
            args.putInt(CURRENT_ITEM, currentItem)
            fragment.arguments = args
            return fragment
        }

        fun newColorInstance(colorList: ArrayList<ColorObj>?, currentColor: Int): LearningElementDetailFragment {
            val fragment = LearningElementDetailFragment()
            val args = Bundle()
            args.putParcelableArrayList(COLOR_LIST, colorList)
            args.putInt(CURRENT_COLOR, currentColor)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view : View  = inflater.inflate(R.layout.letter_detail_frag, container, false)

       return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val elementList = arguments?.getStringArrayList(CURRENT_LIST)
        val colorList: ArrayList<ColorObj>? = arguments?.getParcelableArrayList(COLOR_LIST)
        val pagerAdapter = AlphabetPagerAdapter(activity!!.supportFragmentManager, elementList)
        val colorPagerAdapter = ColorsPagerAdapter(activity!!.supportFragmentManager, colorList)
        val viewPager = letter_detail_viewpager
        // Determines if a color or string learning element has been passed
        if (elementList != null) {
            viewPager.adapter = pagerAdapter
            viewPager.currentItem = arguments!!.getInt(CURRENT_ITEM)
        } else {
            viewPager.adapter = colorPagerAdapter
            viewPager.currentItem = arguments!!.getInt(CURRENT_COLOR)
        }


    }

    inner class AlphabetPagerAdapter(fragmentManager: FragmentManager,
                                     private val learningElements: ArrayList<String>?) :
        FragmentStatePagerAdapter(fragmentManager) {

        override fun getItem(position: Int): Fragment {
            return LearningElementViewPagerPageFragment.newInstance(learningElements!![position])
        }

        override fun getCount(): Int {
            return learningElements!!.size
        }
    }

    inner class ColorsPagerAdapter(fragmentManager: FragmentManager,
                                   private val colors: ArrayList<ColorObj>?) :
            FragmentStatePagerAdapter(fragmentManager) {
        override fun getItem(position: Int): Fragment {
            return LearningElementViewPagerPageFragment.newColorInstance(colors!!.get(position).colorHex)
        }

        override fun getCount(): Int {
            return colors!!.size
        }

    }
}