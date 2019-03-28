package dev.codephoenix.abcapp.ui.main.alphabet

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import dev.codephoenix.abcapp.MainActivity
import dev.codephoenix.abcapp.R
import dev.codephoenix.abcapp.data.LetterModel
import kotlinx.android.synthetic.main.abc_list_item.view.*

class AbcRecyclerViewAdpater(val letters : ArrayList<LetterModel>, val context: Context?,
                             private val activity: MainActivity
) :
    RecyclerView.Adapter<AbcRecyclerViewAdpater.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(context)
            .inflate(R.layout.abc_list_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return letters.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val assignedLetter = LetterModel(letterName = letters[position].letterName)
        holder.letterText?.text = assignedLetter.letterName
        holder.letterText?.setOnClickListener {
            val mainActivity = activity
            val detailFragment = AbcDetailFragment()
            mainActivity.supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, detailFragment)
                .addToBackStack(null)
                .commit()
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val letterText: Button? = view.letter_btn


    }
}
