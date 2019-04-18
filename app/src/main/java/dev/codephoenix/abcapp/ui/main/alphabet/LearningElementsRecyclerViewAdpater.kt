package dev.codephoenix.abcapp.ui.main.alphabet

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import dev.codephoenix.abcapp.MainActivity
import dev.codephoenix.abcapp.R
import kotlinx.android.synthetic.main.abc_list_item.view.*

class LearningElementsRecyclerViewAdpater(
    val letters : ArrayList<String>,
    val context: Context?,
    private val activity: MainActivity
) :
    RecyclerView.Adapter<LearningElementsRecyclerViewAdpater.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(context)
            .inflate(R.layout.abc_list_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return letters.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val assignedLetter = letters[position]
        //pass letter via bundle

        holder.letterText?.text = assignedLetter
        holder.letterText?.setOnClickListener {
            val mainActivity = activity
            mainActivity.supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, LearningElementDetailFragment.newInstance(letters, position))
                .addToBackStack(null)
                .commit()
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val letterText: TextView? = view.letter_btn


    }
}
