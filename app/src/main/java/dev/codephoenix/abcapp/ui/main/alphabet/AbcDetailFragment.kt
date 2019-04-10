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

class AbcDetailFragment : Fragment() {

    companion object {
        val ASSIGNED_LETTER = "assignedLetter"

        fun newInstance(currentPosition: Int): AbcDetailFragment {
            val fragment = AbcDetailFragment()
            val args = Bundle()
            args.putInt(ASSIGNED_LETTER, currentPosition)
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
        val abcList: ArrayList<String> = ArrayList()
        AbcFragment().addAlphabet(abcList)
        val pagerAdapter = AlphabetPagerAdapter(activity!!.supportFragmentManager, abcList)
        val viewPager = letter_detail_viewpager
        viewPager.adapter = pagerAdapter
        viewPager.currentItem = arguments!!.getInt(ASSIGNED_LETTER)

    }

    inner class AlphabetPagerAdapter(fragmentManager: FragmentManager, private val letters: ArrayList<String>) :
        FragmentStatePagerAdapter(fragmentManager) {

        override fun getItem(position: Int): Fragment {
            return LetterPageFragment.newInstance(letters[position])
        }

        override fun getCount(): Int {
            return letters.size
        }

    }
}