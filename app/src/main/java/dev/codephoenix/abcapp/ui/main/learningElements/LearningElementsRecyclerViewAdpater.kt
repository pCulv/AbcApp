package dev.codephoenix.abcapp.ui.main.learningElements

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import dev.codephoenix.abcapp.MainActivity
import dev.codephoenix.abcapp.R
import dev.codephoenix.abcapp.data.ColorObj
import kotlinx.android.synthetic.main.abc_list_item.view.*

class LearningElementsRecyclerViewAdpater(
    val context: Context?,
    private val activity: MainActivity,
    val letters : ArrayList<String>?
) : RecyclerView.Adapter<LearningElementsRecyclerViewAdpater.ViewHolder>() {
    var mColors: ArrayList<ColorObj>? = ArrayList()
    constructor(context: Context?,
                activity: MainActivity,
                letters: ArrayList<String>?,
                colors: ArrayList<ColorObj>?) : this(context, activity, letters) {
        mColors = colors
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(context)
            .inflate(R.layout.abc_list_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return letters?.size ?: mColors!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val assignedElement = letters?.get(position) ?: mColors?.get(position)?.colorName
        //pass letter via bundle

        holder.letterText?.text = assignedElement

        if (letters != null) {
            //set click for letter or numbers to open detail page
            holder.letterText?.setOnClickListener {
                val mainActivity = activity
                mainActivity.supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, LearningElementDetailFragment.newInstance(letters, position))
                    .addToBackStack(null)
                    .commit()
            }
        } else {
            // open color detail page
            val mainActivity = activity
            holder.letterText?.setOnClickListener {
                mainActivity.supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, LearningElementDetailFragment.newColorInstance(mColors, position))
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val letterText: TextView? = view.letter_text


    }
}
