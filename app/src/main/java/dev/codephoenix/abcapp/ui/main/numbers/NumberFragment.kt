package dev.codephoenix.abcapp.ui.main.numbers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import dev.codephoenix.abcapp.MainActivity
import dev.codephoenix.abcapp.R
import kotlinx.android.synthetic.main.fragment_number_list.*

class NumberFragment : Fragment() {

    lateinit var numbers: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addNumbers(numbers)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_number_list, container, false)


        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        // Set the adapter
        numbersRecyclerView?.layoutManager = GridLayoutManager(context, 4)
        numbersRecyclerView?.adapter = MyNumberRecyclerViewAdapter(
            numbers, context, activity as MainActivity)
    }

    fun addNumbers(numbers: MutableList<String>) {

        var number = 1

        while (number <= 100) {
            numbers.add(number.toString())
            ++number
        }
    }

}
