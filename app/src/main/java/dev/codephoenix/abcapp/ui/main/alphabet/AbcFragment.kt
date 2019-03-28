package dev.codephoenix.abcapp.ui.main.alphabet

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.codephoenix.abcapp.MainActivity
import dev.codephoenix.abcapp.R
import dev.codephoenix.abcapp.data.LetterModel
import dev.codephoenix.abcapp.viewmodel.AlphabetViewModel
import kotlinx.android.synthetic.main.abc_fragment.*

class AbcFragment : Fragment(){

    val letters : ArrayList<LetterModel> = ArrayList()
    private lateinit var alphabetViewModel: AlphabetViewModel

    companion object {
        fun newInstance() = AbcFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.abc_fragment, container, false)

        addAlphabet()
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        abc_recyclerview?.layoutManager = GridLayoutManager(context, 4)
        abc_recyclerview?.adapter = AbcRecyclerViewAdpater(letters, context,
            activity = activity as MainActivity
        )


    }

    // Todo: add Alphabet list to database
    fun addAlphabet() {

        val a = LetterModel("A")
        val b = LetterModel("B")
        val c = LetterModel("C")
        val d = LetterModel("D")
        val e = LetterModel("E")
        val f = LetterModel("F")
        val g = LetterModel("G")
        val h = LetterModel("H")
        val i = LetterModel("I")
        val j = LetterModel("J")
        val k = LetterModel("K")
        val l = LetterModel("L")
        val m = LetterModel("M")
        val n = LetterModel("N")
        val o = LetterModel("O")
        val p = LetterModel("P")
        val q = LetterModel("Q")
        val r = LetterModel("R")
        val s = LetterModel("S")
        val t = LetterModel("T")
        val u = LetterModel("U")
        val v = LetterModel("V")
        val w = LetterModel("W")
        val x = LetterModel("X")
        val y = LetterModel("Y")
        val z = LetterModel("Z")

        letters.add(a)
        letters.add(b)
        letters.add(c)
        letters.add(d)
        letters.add(e)
        letters.add(f)
        letters.add(g)
        letters.add(h)
        letters.add(i)
        letters.add(j)
        letters.add(k)
        letters.add(l)
        letters.add(m)
        letters.add(n)
        letters.add(o)
        letters.add(p)
        letters.add(q)
        letters.add(r)
        letters.add(s)
        letters.add(t)
        letters.add(u)
        letters.add(v)
        letters.add(w)
        letters.add(x)
        letters.add(y)
        letters.add(z)
    }
}
