package dev.codephoenix.abcapp.ui.main.alphabet


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.codephoenix.abcapp.R
import kotlinx.android.synthetic.main.letter_page.*

class LetterPageFragment : Fragment() {


    companion object {
        fun newInstance(currentLetter: String): LetterPageFragment {
            val ASSIGNED_LETTER = "assignedLetter"
            val fragment = LetterPageFragment()
            val args = Bundle()
            args.putString(ASSIGNED_LETTER, currentLetter)
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
        val ASSIGNED_LETTER = "assignedLetter"
        letter_page_tv!!.text = arguments?.getString(ASSIGNED_LETTER)
    }
}





