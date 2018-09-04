package com.shurikus.boostnoteandroid.ui.note.list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.shurikus.boostnoteandroid.Const
import com.shurikus.boostnoteandroid.R
import com.shurikus.boostnoteandroid.entity.NoteEntity

class NotesAdapter(private val items: List<NoteEntity>,
                   private val clickListener: (NoteEntity) -> Unit) : RecyclerView.Adapter<NotesAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesAdapter.Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return NotesAdapter.Holder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: NotesAdapter.Holder, position: Int) {
        val context = holder.noteImage.context
        val item = items[position]
        holder.noteName.text = item.title
        when(item.type) {
            Const.NoteType.MARKDOWN_NOTE.toString() -> {
                holder.noteImage.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_note))
            }
            Const.NoteType.SNIPPET_NOTE.toString() -> {
                holder.noteImage.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_snippet))
            }
        }
        holder.rootLayout.setOnClickListener {
            clickListener(item)
        }
    }

    class Holder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var noteName: TextView = itemView.findViewById(R.id.noteNameText)
        internal var noteImage: ImageView = itemView.findViewById(R.id.noteImage)
        internal var rootLayout: ConstraintLayout = itemView.findViewById(R.id.rootLayout)
    }


}