package dev.codephoenix.abcapp.ui.main.alphabet

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.codephoenix.abcapp.MainActivity
import dev.codephoenix.abcapp.R
import dev.codephoenix.abcapp.viewmodel.AlphabetViewModel
import kotlinx.android.synthetic.main.abc_fragment.*

class AbcFragment : Fragment() {

    val letters: ArrayList<String> = ArrayList()
    private lateinit var alphabetViewModel: AlphabetViewModel

    companion object {
        fun newInstance() = AbcFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.abc_fragment, container, false)

        addAlphabet(letters)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        abc_recyclerview?.layoutManager = GridLayoutManager(context, 4)
        abc_recyclerview?.adapter = AbcRecyclerViewAdpater(
            letters, context,
            activity = activity as MainActivity
        )


    }

    // Todo: add Alphabet list to database
    fun addAlphabet(abcList: ArrayList<String>) {

        var letter = 'A'

        while (letter <= 'Z') {
            abcList.add(letter.toString())
            ++letter
        }
    }
}
