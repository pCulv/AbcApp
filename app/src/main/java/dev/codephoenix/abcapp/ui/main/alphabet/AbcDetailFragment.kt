package dev.codephoenix.abcapp.ui.main.alphabet

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.codephoenix.abcapp.R

class AbcDetailFragment : Fragment() {

    private lateinit var viewPager: ViewPager
    
    companion object {
        fun newInstance(assignedLetter: String): AbcDetailFragment{
            val fragment = AbcDetailFragment()
            val letterKey = "assignedLetter"
            val args = Bundle()
            args.putString(letterKey, assignedLetter)
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

//        val letterKey = "assignedLetter"
//
//        val assignedLetter: String? = arguments?.getString(letterKey)
//        Timber.i("Letter is : %s", assignedLetter)
//        letter_detail_viewpager?.text = assignedLetter
    }
}