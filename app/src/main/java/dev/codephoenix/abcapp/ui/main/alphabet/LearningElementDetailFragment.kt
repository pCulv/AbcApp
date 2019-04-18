package dev.codephoenix.abcapp.ui.main.alphabet

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.codephoenix.abcapp.R
import kotlinx.android.synthetic.main.letter_detail_frag.*

class LearningElementDetailFragment : Fragment() {

    companion object {

        val CURRENT_LIST = "currentList"
        val CURRENT_ITEM = "itemPosition"

        fun newInstance(currentList: ArrayList<String>, currentItem: Int): LearningElementDetailFragment {
            val fragment = LearningElementDetailFragment()
            val args = Bundle()
            args.putStringArrayList(CURRENT_LIST, currentList)
            args.putInt(CURRENT_ITEM, currentItem)
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
        val elementList = arguments!!.getStringArrayList(CURRENT_LIST)
        val pagerAdapter = AlphabetPagerAdapter(activity!!.supportFragmentManager, elementList)
        val viewPager = letter_detail_viewpager
        viewPager.adapter = pagerAdapter
        viewPager.currentItem = arguments!!.getInt(CURRENT_ITEM)

    }

    inner class AlphabetPagerAdapter(fragmentManager: FragmentManager, private val learningElements: ArrayList<String>) :
        FragmentStatePagerAdapter(fragmentManager) {

        override fun getItem(position: Int): Fragment {
            return LearningElementViewPagerPageFragment.newInstance(learningElements[position])
        }

        override fun getCount(): Int {
            return learningElements.size
        }

    }
}