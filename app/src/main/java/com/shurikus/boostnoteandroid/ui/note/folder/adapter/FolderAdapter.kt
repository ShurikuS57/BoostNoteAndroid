package com.shurikus.boostnoteandroid.ui.note.folder.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.shurikus.boostnoteandroid.R
import com.shurikus.boostnoteandroid.entity.Folders

class FolderAdapter(private val items: List<Folders.Folder>,
                    private val clickListener: (Folders.Folder) -> Unit) : RecyclerView.Adapter<FolderAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_folder, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = items[position]
        holder.folderName.text = item.name
        holder.rootLayout.setOnClickListener {
            clickListener(item)
        }
    }

    class Holder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var folderName: TextView = itemView.findViewById(R.id.noteNameText)
        internal var rootLayout: ConstraintLayout = itemView.findViewById(R.id.rootLayout)
    }


}