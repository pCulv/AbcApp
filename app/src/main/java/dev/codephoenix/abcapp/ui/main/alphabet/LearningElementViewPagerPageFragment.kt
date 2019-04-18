package dev.codephoenix.abcapp.ui.main.alphabet


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.codephoenix.abcapp.R
import kotlinx.android.synthetic.main.letter_page.*

class LearningElementViewPagerPageFragment : Fragment() {

    //This is the fragment that is handled by the ViewPager in the LayoutElementDetailFragment
    companion object {
        fun newInstance(currentElement: String): LearningElementViewPagerPageFragment {
            val ASSIGNED_ELEMENT = "assignedLetter"
            val fragment = LearningElementViewPagerPageFragment()
            val args = Bundle()
            args.putString(ASSIGNED_ELEMENT, currentElement)
            fragment.arguments = args

            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return layoutInflater.inflate(R.layout.letter_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val ASSIGNED_ELEMENT = "assignedLetter"
        letter_page_tv!!.text = arguments?.getString(ASSIGNED_ELEMENT)
    }
}





