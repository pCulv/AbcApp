package dev.codephoenix.abcapp.ui.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.codephoenix.abcapp.MainActivity
import dev.codephoenix.abcapp.R
import dev.codephoenix.abcapp.ui.main.alphabet.AbcFragment
import timber.log.Timber

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
        val abcCardView = view.findViewById<View>(R.id.abc_card)
        abcCardView.setOnClickListener {
            val mainActivity : MainActivity = activity as MainActivity
            mainActivity.supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, AbcFragment.newInstance())
                .addToBackStack(null)
                .commit()
            Timber.i("Timber works")
        }
    }

    companion object {
        fun newInstance() = MainFragment()
    }

}
