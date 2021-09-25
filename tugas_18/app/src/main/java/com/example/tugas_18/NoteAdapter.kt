package com.example.tugas_18

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter(
    val notes: ArrayList<ModelNote.Data>,
    val listener: OnAdapterListener,
    ):RecyclerView.Adapter<NoteAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_note, parent, false)
    )

    override fun onBindViewHolder(holder: NoteAdapter.ViewHolder, position: Int) {
        val data = notes[position]
        holder.textNote.text = data.note
        holder.itemView.setOnClickListener{
            listener.onClick(data)
        }
        holder.imageDelete.setOnClickListener{
            listener.onDelete(data)
        }
    }

    override fun getItemCount() = notes.size

    class ViewHolder(view:View): RecyclerView.ViewHolder(view){
        val textNote = view.findViewById<TextView>(R.id.text_note)
        val imageDelete = view.findViewById<ImageView>(R.id.image_delete)
    }
    public fun setData(data: List<ModelNote.Data>){
        notes.clear()
        notes.addAll(data)
        notifyDataSetChanged()
    }
    interface OnAdapterListener {
        fun onClick(note: ModelNote.Data)
        fun onDelete(note: ModelNote.Data)
    }
}