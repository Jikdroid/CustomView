package org.boostcamp.uniletter_spinner

import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class JikpinnerAdapter(private val items: Array<CharSequence>) :
    RecyclerView.Adapter<JikpinnerAdapter.ViewHolder>() {

    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(text: String) {
            view.findViewById<TextView>(R.id.item).run {
                this.text = text
                setOnClickListener {
                    Log.d("Jikpinner", "$text clicked")
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JikpinnerAdapter.ViewHolder {
        val view = View.inflate(parent.context, R.layout.item_jikpinner, null)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: JikpinnerAdapter.ViewHolder, position: Int) {
        holder.bind(items[position].toString())
    }

    override fun getItemCount() = items.size
}
