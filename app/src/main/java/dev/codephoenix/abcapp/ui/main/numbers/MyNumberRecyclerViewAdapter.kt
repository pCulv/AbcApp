package dev.codephoenix.abcapp.ui.main.numbers


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.codephoenix.abcapp.MainActivity
import dev.codephoenix.abcapp.R
import kotlinx.android.synthetic.main.fragment_number.view.*

class MyNumberRecyclerViewAdapter(
    val numbers : ArrayList<Int>, val context: Context?,
    private val activity: MainActivity
) : RecyclerView.Adapter<MyNumberRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_number, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val assignedNumber = numbers[position]
        //pass letter via bundle

        holder.numberText.text = assignedNumber.toString()
        holder.numberText.setOnClickListener {
            val mainActivity = activity
            mainActivity.supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, NumberDetailFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    override fun getItemCount(): Int = numbers.size

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val numberText = view.number_btn!!
    }
}
